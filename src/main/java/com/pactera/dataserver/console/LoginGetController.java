package com.pactera.dataserver.console;

import com.pactera.dataserver.core.http.CusRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cht
 */
@Controller
public class LoginGetController {
    @Autowired
    private CusRestTemplate crt;

    @GetMapping(value = {"/yamagatabank.data.server/YGIK01/BankIS", "/yamagatabank.data.server/YGIK02/BankIS"}, produces = "text/html;charset=Windows-31J")
    public String loginGet(@RequestParam("xtr") String xtr, Model model) {
        return "login";
    }
}

