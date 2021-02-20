package com.hanko.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: hanko
 * @Date: 2021-2-3 20:04
 */
@Controller
public class LoginController {
    @RequestMapping("/token/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/token/success")
    @ResponseBody
    public String success() {
        return "success";
    }

}
