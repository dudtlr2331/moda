package com.moda.moda.user;

import com.moda.moda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "html/moda/user/login";
    }

    @GetMapping("/join")
    public String join() {
        return "html/moda/user/join";
    }

    @GetMapping("/users")
    public String selectUserList(HttpServletRequest req, HttpServletResponse res, UserVO pvo) {

        pvo = (UserVO) userService.selectUserList(pvo);
        req.setAttribute("pvo", pvo);

        return "html/moda/user/login";
    }
}
