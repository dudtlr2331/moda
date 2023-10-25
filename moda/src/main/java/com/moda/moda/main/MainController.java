package com.moda.moda.main;

import com.moda.moda.user.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("/main")
    public String show(Model model, HttpSession session) {
        // 세션에서 loginInfo를 가져와서 모델에 추가
        UserVO loginInfo = (UserVO) session.getAttribute("loginInfo");
        model.addAttribute("loginInfo", loginInfo);
        return "html/moda/main/main";
    }

//    @GetMapping("/product")
//    public String product() {
//        return "product";
//    }
}
