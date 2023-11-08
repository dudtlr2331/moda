package com.moda.adm.qna;

import com.moda.adm.qna.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
