package com.moda.moda.mypage;

import com.moda.moda.member.MemberVO;
import com.moda.moda.mypage.service.MypgService;
import com.moda.moda.order.OrderVO;
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

    @Autowired
    public MypgController(MypgService mypgService) {
        this.mypgService = mypgService;
    }

    // 주문내역
    @RequestMapping("/mypage/mypaOrdList.do")
    public String mypgOrderList(Model model, HttpSession session) {
        String uId = (String) session.getAttribute("uId");
        String uAdmin = (String) session.getAttribute("uAdmin");
        model.addAttribute("uId", uId);
        model.addAttribute("uAdmin", uAdmin);

        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        String usrId = loginInfo.getUId();

        List<MypgVO> mypgList = mypgService.selectMypgList(usrId);
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
