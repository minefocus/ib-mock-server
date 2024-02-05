package com.pactera.dataserver.console;

import com.pactera.dataserver.api.exception.SbcfRequestException;
import com.pactera.dataserver.core.http.CusRestTemplate;
import com.pactera.dataserver.core.sbcf.configuration.ApiEnum;
import com.pactera.dataserver.model.CommonModel;
import com.pactera.dataserver.model.DetailModel;
import com.pactera.dataserver.model.HomeModel;
import com.pactera.dataserver.vo.BankApiErrorMessageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author cht
 */
@Controller
public class CommonController {
    @Autowired
    private CusRestTemplate crt;

    @PostMapping(value = {"/yamagatabank.data.server/YGIK01/BankIS", "/yamagatabank.data.server/YGIK02/BankIS"}, produces = "text/html;charset=Windows-31J")
    public String login(@ModelAttribute CommonModel data, Model model) throws Exception {
        if ("isaulogon02000".equals(data.getXtr())) {
            return "login";
        } else if ("isktinit01000".equals(data.getXtr())) {
            HttpHeaders headers = new HttpHeaders();
            Map<String, String> mapLogin = new HashMap<>(0);
            mapLogin.put("accntNo", data.getAccntNo());
            Optional<CommonModel> responseLogin = crt.getForEntityOrElseThrow(ApiEnum.login, headers, CommonModel.class, BankApiErrorMessageVo.class, (error, e) -> {
                throw new SbcfRequestException();
            }, mapLogin);
            if (responseLogin.isPresent()) {
                if (!StringUtils.isEmpty(responseLogin.get().getErr_msg_home())) {
                    model.addAttribute("errMsgHome", responseLogin.get().getErr_msg_home());
                    return "login";
                } else {
                    Map<String, String> map = new HashMap<>(0);
                    map.put("accntNo", data.getAccntNo());
                    Optional<HomeModel> response = crt.getForEntityOrElseThrow(ApiEnum.home, headers, HomeModel.class, BankApiErrorMessageVo.class, (error, e) -> {
                        throw new SbcfRequestException();
                    }, map);
                    response.ifPresent(v -> {
                        LocalDateTime now = LocalDateTime.parse(v.getKijun_date(), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
                        v.setKijun_date(now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分")) + " 現在");
                        model.addAttribute("data", v);
                    });

                    return "home";
                }
            }
        } else {
            model.addAttribute("accntNo", data.getAccntNo());
            model.addAttribute("next", data.getNext());
            if (StringUtils.isEmpty(data.getSearchYearFrom())) {
                return "detail";
            }
            HttpHeaders headers = new HttpHeaders();
            Map<String, String> map = new HashMap<>(0);
            map.put("searchDateFrom", data.getSearchYearFrom() + zeroPad(data.getSearchMonthFrom()) + zeroPad(data.getSearchDayFrom()));
            map.put("searchDateTo", data.getSearchYearTo() + zeroPad(data.getSearchMonthTo()) + zeroPad(data.getSearchDayTo()));
            map.put("next", data.getNext());
            map.put("accntNo", data.getAccntNo());
            Optional<DetailModel> response = crt.getForEntityOrElseThrow(ApiEnum.detail, headers, DetailModel.class, BankApiErrorMessageVo.class, (error, e) -> {
                throw new SbcfRequestException();
            }, map);
            if (response.isPresent()) {
                TimeUnit.SECONDS.sleep(response.get().getSleep());
                model.addAttribute("data", response.get().getDetailList());
                model.addAttribute("next", Integer.valueOf(response.get().getNext()));
                model.addAttribute("err_msg", response.get().getErr_msg());
            }
            return "detail";
        }
        return "login";
    }

    private String zeroPad(String str) {
        return StringUtils.leftPad(str, 2, "0");
    }
}

