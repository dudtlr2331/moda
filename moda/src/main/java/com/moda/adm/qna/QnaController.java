package com.moda.adm.qna;

import com.moda.adm.qna.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QnaController {
    private final QnaService qnaService;

    @GetMapping("/adm/qna.do")
    public String openPostList(Model model){
        List<QnaDto> qnas = qnaService.findAllQna();
        model.addAttribute("qnas", qnas);
        for(QnaDto data: qnas) {
            System.out.println(data);
        }
//        String a = "a", b = "b";
//        model.addAttribute("a", a);
//        model.addAttribute("b", b);
        return "html/adm/qna/adm_qna";
    }
}