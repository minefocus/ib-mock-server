package com.pactera.dataserver.console;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cht
 */
@Controller
public class LoginGetController {

    @GetMapping(value = {"/YGIK01/BankIS",
            "/YGIK02/BankIS",
            "/AWIK01/BankIS",
            "/AWIK02/BankIS",}, produces = "text/html;charset=Windows-31J")
    public String loginGet(@RequestParam("xtr") String xtr, Model model, HttpServletRequest request) {
        model.addAttribute("actionUrl", request.getRequestURI());
        if ("isasismk01000".equals(xtr)) {
            return "user_registration_1";
        } else {
            return "login";
        }
    }
}

