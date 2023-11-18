package com.moda.moda.main;

import com.moda.moda.main.service.MainService;
import com.moda.moda.member.MemberVO;
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
        String uId = (String) session.getAttribute("uId");
        String uAdmin = (String) session.getAttribute("uAdmin");
        model.addAttribute("uId", uId);
        model.addAttribute("uAdmin", uAdmin);

        // 상품 리스트 가져와서 모델에 추가
        List<MainVO> mainHomeList = mainService.selectListMainHome();
        model.addAttribute("mainHomeList", mainHomeList);

        return "html/moda/main/main";
    }

}
