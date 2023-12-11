package com.moda.moda.main;

import com.moda.adm.category.CateVO;
import com.moda.adm.category.service.CateService;
import com.moda.moda.main.service.MainService;
import com.moda.moda.member.MemberVO;
import com.moda.moda.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    private final MemberService memberService;
    private final MainService mainService;
private final CateService cateService;
    @Autowired
    public MainController(MemberService memberService, MainService mainService , CateService cateService) {
        this.memberService = memberService;
        this.mainService = mainService;
        this.cateService = cateService;
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
        List<CateVO> cvo = cateService.selectCateList();
        for (CateVO cateVO : cvo) {
            cateVO.setSubCate(cateService.selectCateUnList(cateVO));
        }
        model.addAttribute("categoryList", cvo);
        return "html/moda/main/main";
    }

    /**
     * 마이페이지 폼
     * @return
     */
    @GetMapping("/moda/main/mypage.do")
    public String myPageForm(Model model, HttpSession session){
        String uId = (String) session.getAttribute("uId");
        MemberVO memberInfo = memberService.findByMember(uId);
        model.addAttribute("uId", memberInfo.getUId());
        model.addAttribute("uAdmin", memberInfo.getUAdmin());
        model.addAttribute("uName", memberInfo.getUName());
        model.addAttribute("uEmail", memberInfo.getUEmail());
        model.addAttribute("uAddr", memberInfo.getUAddr());
        model.addAttribute("uPhone", memberInfo.getUPhone());
        return "html/moda/main/mypage";
    }
}
