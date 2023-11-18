package com.moda.moda.main;

import com.moda.moda.main.service.MainService;
import com.moda.moda.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/main")
    public String show(Model model, HttpSession session) {
        // 세션에서 loginInfo를 가져와서 모델에 추가
        UserVO loginInfo = (UserVO) session.getAttribute("loginInfo");
        model.addAttribute("loginInfo", loginInfo);

        // 상품 리스트 가져와서 모델에 추가
        List<MainVO> mainHomeList = mainService.selectListMainHome();
        model.addAttribute("mainHomeList", mainHomeList);

        return "html/moda/main/main";
    }

}
