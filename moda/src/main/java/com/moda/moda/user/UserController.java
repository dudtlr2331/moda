package com.moda.moda.user;

import com.moda.moda.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String join() { return "html/moda/user/join"; }

    @GetMapping("/edit")
    public String edit() {
        return "html/moda/user/edit";
    }

//    @GetMapping("/users")
//    public String selectUserList(HttpServletRequest req, HttpServletResponse res, UserVO pvo) {
//
//        List<UserVO> userList = userService.selectUserList(pvo);
//
//        // 사용자 목록을 request에 설정
//        req.setAttribute("userList", userList);
//
//        return "html/moda/user/login";
//    }
    @GetMapping("/users")
    public String selectUserList(Model model, UserVO pvo) {
        List<UserVO> userList = userService.selectUserList(pvo); // UserService를 통해 selectUserList 메서드 호출
        model.addAttribute("userList", userList); // "userList"라는 이름으로 모델에 데이터 추가

        return "html/moda/user/login";
    }
}
