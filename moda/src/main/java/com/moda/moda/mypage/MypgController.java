package com.moda.moda.mypage;

import com.moda.adm.category.CateVO;
import com.moda.adm.category.service.CateService;
import com.moda.moda.mypage.service.MypgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MypgController {
    private final MypgService mypgService;
    private final CateService cateService;

    @Autowired
    public MypgController(MypgService mypgService, CateService cateService) {
        this.mypgService = mypgService;
        this.cateService = cateService;
    }

    // 주문내역
    @RequestMapping("/mypage/mypaOrdList.do")
    public String mypgOrderList(Model model, HttpSession session) {
        String uId = (String) session.getAttribute("uId");
        String uAdmin = (String) session.getAttribute("uAdmin");
        model.addAttribute("uId", uId);
        model.addAttribute("uAdmin", uAdmin);

        List<CateVO> cvo = cateService.selectCateList();
        for (CateVO cateVO : cvo) {
            cateVO.setSubCate(cateService.selectCateUnList(cateVO));
        }
        List<MypgVO> mypgList = mypgService.selectMypgList(uId);

        model.addAttribute("categoryList", cvo);
        model.addAttribute("mypgList", mypgList);
        return "html/moda/mypage/mypage_ord_list";
    }

    @RequestMapping("/mypage/mypageDetail.do")
    public String mypageDetail(HttpServletRequest req, HttpSession session, Model model) {
        String uId = (String) session.getAttribute("uId");
        String uAdmin = (String) session.getAttribute("uAdmin");
        model.addAttribute("uId", uId);
        model.addAttribute("uAdmin", uAdmin);

        MypgVO ordList = mypgService.selectMypgDetail(req.getParameter("ordNo"));

        model.addAttribute("ordList", ordList);
        return "html/moda/mypage/mypage_detail";
    }
}
