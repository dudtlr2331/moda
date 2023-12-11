package com.moda.moda.review;

import com.moda.moda.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    public String reviewSave(@ModelAttribute ReviewVO reviewVO, HttpSession session , Model model){
        String uId = (String) session.getAttribute("uId");
        model.addAttribute("uId", uId);
        reviewService.createReview(reviewVO);

    return "redirect:/mypage/mypaOrdList.do";
    }

    @PostMapping(value = "/review/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> deleteReview(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();


        // JSON 데이터에서 reviewId 추출하고 Integer로 변환
        Integer reviewIdObj = Integer.parseInt((String) request.get("reviewId"));
        System.out.println(reviewIdObj);
        // reviewId를 사용하여 리뷰 삭제 작업 수행
        boolean success = reviewService.deleteReview(reviewIdObj);
        response.put("success", success);
        System.out.println(response);
        return response;
    }
}
