package com.moda.adm.qna;

import com.moda.adm.qna.service.QnaService;
import com.moda.cmm.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QnaController {
    private final QnaService qnaService;

    @GetMapping("/adm/qna.do")
    public String openQnaList(Model model){
        List<QnaDto> qnas = qnaService.findAllQna();
        model.addAttribute("qnas", qnas);
        return "html/adm/qna/adm_qna";
    }

    @GetMapping("/adm/qnaview.do")
    public String openQnaView(@RequestParam final Long num, Model model){
        QnaDto qna = qnaService.findQnaByNum(num);
        model.addAttribute("qna", qna);
        return "html/adm/qna/adm_qna_view";
    }

    @GetMapping("/adm/qnaupdate.do")
    public String updateQna(final QnaSearch params, Model model){
        qnaService.updateQna(params);
        MessageDto message = new MessageDto("문의 답변 완료.", "/adm/qna.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "html/common/messageRedirect";
    }

}
