package com.pactera.dataserver.console;

import com.pactera.dataserver.core.ib.configuration.ApiEnum;
import com.pactera.dataserver.model.CommonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cht
 */
@Controller
public class LoginGetController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${yamagatabank.base.url}")
    private String yamagataBaseUrl;
    @Value("${awabank.base.url}")
    private String awaBaseUrl;
    private static final String YGIK = "YGIK";
    public static final String AWIK = "AWIK";

    @GetMapping(value = {"/YGIK01/BankIS",
            "/YGIK02/BankIS",
            "/AWIK01/BankIS",
            "/AWIK02/BankIS",}, produces = "text/html;charset=Windows-31J")
    public String loginGet(@RequestParam("xtr") String xtr, Model model, HttpServletRequest request) {
        model.addAttribute("actionUrl", request.getRequestURI());
        String url = request.getRequestURI();
        String baseUrl;
        if (url.contains(YGIK)) {
            baseUrl = yamagataBaseUrl;
        } else {
            baseUrl = awaBaseUrl;
        }
        if ("isasismk01000".equals(xtr)) {
            ResponseEntity<CommonModel> usageRegulation = restTemplate.exchange(baseUrl.concat(ApiEnum.usageRegulation.getPath()),
                    ApiEnum.usageRegulation.getMethod(),
                    new HttpEntity<>(new HttpHeaders()),
                    CommonModel.class);
            CommonModel usageRegulationModel = usageRegulation.getBody();
            model.addAttribute("data", usageRegulationModel);
            return "user_registration_1";
        } else {
            return "login";
        }
    }
}

