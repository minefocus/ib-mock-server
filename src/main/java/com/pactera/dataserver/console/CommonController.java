package com.pactera.dataserver.console;

import com.pactera.dataserver.core.ib.configuration.ApiEnum;
import com.pactera.dataserver.model.CommonModel;
import com.pactera.dataserver.model.DetailModel;
import com.pactera.dataserver.model.HomeModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author cht
 */
@Controller
public class CommonController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${yamagatabank.base.url}")
    private String yamagataBaseUrl;
    @Value("${awabank.base.url}")
    private String awaBaseUrl;
    private static final String YGIK = "YGIK";
    public static final String AWIK = "AWIK";

    @PostMapping(value = {"/YGIK01/BankIS",
            "/YGIK02/BankIS",
            "/AWIK01/BankIS",
            "/AWIK02/BankIS"}, produces = "text/html;charset=Windows-31J")
    public String login(@ModelAttribute CommonModel data, Model model, HttpServletRequest request) throws InterruptedException {
        String url = request.getRequestURI();
        model.addAttribute("actionUrl", url);
        String baseUrl;
        if (url.contains(YGIK)) {
            baseUrl = yamagataBaseUrl;
        } else {
            baseUrl = awaBaseUrl;
        }
        if ("isaulogon02000".equals(data.getXtr())) {
            return "login";
        } else if ("isktinit01000".equals(data.getXtr())) {
            Map<String, String> mapLogin = new HashMap<>(0);
            mapLogin.put("accntNo", data.getAccntNo());
            mapLogin.put("password", data.getPass());
            ResponseEntity<CommonModel> login = restTemplate.exchange(baseUrl.concat(ApiEnum.login.getPath()),
                    ApiEnum.login.getMethod(),
                    new HttpEntity<>(new HttpHeaders()),
                    CommonModel.class,
                    mapLogin);
            CommonModel loginResponse = login.getBody();
            if (loginResponse != null) {
                if (!StringUtils.isEmpty(loginResponse.getErr_msg_home())) {
                    model.addAttribute("errMsgHome", loginResponse.getErr_msg_home());
                    return "login";
                } else {
                    Map<String, String> map = new HashMap<>(0);
                    map.put("accntNo", data.getAccntNo());
                    ResponseEntity<HomeModel> home = restTemplate.exchange(baseUrl.concat(ApiEnum.home.getPath()),
                            ApiEnum.home.getMethod(),
                            new HttpEntity<>(new HttpHeaders()),
                            HomeModel.class,
                            map);
                    HomeModel homeModel = home.getBody();
                    if (homeModel != null) {
                        LocalDateTime now = LocalDateTime.parse(homeModel.getKijun_date(), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
                        homeModel.setKijun_date(now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分")) + " 現在");
                        model.addAttribute("data", homeModel);
                    }
                    return "home";
                }
            }
        } else if ("isasismk01000".equals(data.getXtr())) {
            return "user_registration_1";
        } else if ("user_registration_2".equals(data.getXtr())) {
            return "user_registration_2";
        } else if ("user_registration_3".equals(data.getXtr())) {
            return "user_registration_3";
        } else if ("user_registration_4".equals(data.getXtr())) {
            return "user_registration_4";
        } else if ("user_registration_5".equals(data.getXtr())) {
            return "user_registration_5";
        } else if ("user_registration_6".equals(data.getXtr())) {
            return "user_registration_6";
        } else {
            model.addAttribute("accntNo", data.getAccntNo());
            model.addAttribute("next", data.getNext());
            if (StringUtils.isEmpty(data.getSearchYearFrom())) {
                return "detail";
            }
            Map<String, String> map = new HashMap<>(0);
            map.put("searchDateFrom", data.getSearchYearFrom() + zeroPad(data.getSearchMonthFrom()) + zeroPad(data.getSearchDayFrom()));
            map.put("searchDateTo", data.getSearchYearTo() + zeroPad(data.getSearchMonthTo()) + zeroPad(data.getSearchDayTo()));
            map.put("next", data.getNext());
            map.put("accntNo", data.getAccntNo());
            ResponseEntity<DetailModel> detail = restTemplate.exchange(baseUrl.concat(ApiEnum.detail.getPath()),
                    ApiEnum.detail.getMethod(),
                    new HttpEntity<>(new HttpHeaders()),
                    DetailModel.class,
                    map);
            DetailModel detailModel = detail.getBody();
            if (detailModel != null) {
                TimeUnit.SECONDS.sleep(detailModel.getSleep());
                model.addAttribute("data", detailModel.getDetailList());
                model.addAttribute("next", Integer.valueOf(detailModel.getNext()));
                model.addAttribute("err_msg", detailModel.getErr_msg());
            }
            return "detail";
        }

        return "login";
    }

    private String zeroPad(String str) {
        return StringUtils.leftPad(str, 2, "0");
    }
}

