package com.moda.adm.qna;

import com.moda.adm.category.CateVO;
import com.moda.adm.category.service.CateService;
import com.moda.adm.qna.service.QnaService;
import com.moda.adm.search.SearchDto;
import com.moda.cmm.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class QnaController {
    private final QnaService qnaService;
    private final CateService cateService;

    //문의 관리 페이지
    @GetMapping("/adm/qna.do")
    public String openQnaList(@ModelAttribute("params") final SearchDto params, Model model){
        List<QnaDto> qnas = qnaService.findAllQna(params);
        model.addAttribute("qnas", qnas);
        return "html/adm/qna/adm_qna";
    }

    //문의 상세 페이지
    @GetMapping("/adm/qnaview.do")
    public String openQnaView(@RequestParam final Long num, Model model){
        QnaDto qna = qnaService.findQnaByNum(num);
        model.addAttribute("qna", qna);
        return "html/adm/qna/adm_qna_view";
    }

    //문의 업데이트
    @GetMapping("/adm/qnaupdate.do")
    public String updateQna(final QnaSearch params, Model model){
        qnaService.updateQna(params);
        MessageDto message = new MessageDto("문의 답변 완료.", "/adm/qna.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    //문의 페이지(유저)
    @GetMapping("/moda/qnapage.do")
    public String openQnaPage(HttpServletRequest req, Model model){
        HttpSession session = req.getSession();
        String uId = (String) session.getAttribute("uId");
        String uAdmin = (String) session.getAttribute("uAdmin");
        List<QnaDto> qnas = qnaService.findQnaById(uId);
        model.addAttribute("qnas", qnas);
        model.addAttribute("uId", uId);
        model.addAttribute("uAdmin", uAdmin);
        List<CateVO> cvo = cateService.selectCateList();
        for (CateVO cateVO : cvo) {
            cateVO.setSubCate(cateService.selectCateUnList(cateVO));
        }
        model.addAttribute("categoryList", cvo);
        return "html/moda/main/mypage-qna";
    }

    //문의 답변 보기(유저)
    @GetMapping("/moda/qnaview.do")
    public String openQnaViewPage(@RequestParam final Long num, Model model, HttpServletRequest req){
        HttpSession session = req.getSession();
        String uId = (String) session.getAttribute("uId");
        String uAdmin = (String) session.getAttribute("uAdmin");
        QnaDto qna = qnaService.findQnaByNum(num);
        model.addAttribute("qna", qna);
        model.addAttribute("uId", uId);
        model.addAttribute("uAdmin", uAdmin);
        List<CateVO> cvo = cateService.selectCateList();
        for (CateVO cateVO : cvo) {
            cateVO.setSubCate(cateService.selectCateUnList(cateVO));
        }
        model.addAttribute("categoryList", cvo);
        return "html/moda/main/qna_view";
    }

    //문의 작성(유저)
    @GetMapping("/moda/qnawrite")
    public String insertQna(final QnaSearch params, HttpServletRequest req, Model model){
        HttpSession session = req.getSession();
        String uId = (String) session.getAttribute("uId");
        params.setUId(uId);
        qnaService.insertQna(params);
        MessageDto message = new MessageDto("문의 작성 완료.", "/moda/qnapage.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "html/common/messageRedirect";
    }

}
