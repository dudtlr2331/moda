package com.moda.moda.review;

import com.moda.moda.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor

public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/dress/dressRegister.do")
    public String reviewWrite(Model model, HttpSession session){
        String uId = (String) session.getAttribute("uId");
        String uAdmin = (String) session.getAttribute("uAdmin");
        model.addAttribute("uId", uId);
        model.addAttribute("uAdmin", uAdmin);
        return "html/moda/review/review";
    }

    @PostMapping("/review/write")
    public String reviewSave(@ModelAttribute ReviewVO reviewVO){
    System.out.println(reviewVO);
    return "redirect:/dress/dressRegister.do";
    }
}
