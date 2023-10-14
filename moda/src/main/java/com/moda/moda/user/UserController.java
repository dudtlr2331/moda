package com.moda.moda.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/login")
    public String login() {
        return "html/moda/user/login";
    }

    @GetMapping("/join")
    public String join() {
        return "html/moda/user/join";
    }

}
