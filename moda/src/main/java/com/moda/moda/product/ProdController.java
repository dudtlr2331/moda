package com.moda.moda.product;

import com.moda.adm.category.CateVO;
import com.moda.adm.category.service.CateService;
import com.moda.moda.product.service.ProdService;
import com.moda.moda.review.ReviewVO;
import com.moda.moda.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
@RequiredArgsConstructor
@Controller
public class ProdController {
    private final ProdService prodService;
    private final CateService cateService;
    private final ReviewService reviewService;
    @GetMapping("/product/prodList")
    public String selectProdList(ProdVO pvo) {
        List<ProdVO> prodList = prodService.selectProdList(pvo);
        System.out.println(prodList);

        return "html/moda/main/main";
    }
@GetMapping("/product/itemlist")
    public String allProdList(@RequestParam(name = "category", required = false) String category , Model model,ProdVO pvo ,HttpSession session) {
    if (category == null) {
        List<ProdVO> prodList = prodService.selectProdList(pvo);
        model.addAttribute("mainHomeList",prodList);
    }else
    {
        List<ProdVO> prodList = prodService.selectCateProd(category);
        model.addAttribute("mainHomeList",prodList);
    }
    String uId = (String) session.getAttribute("uId");
    String uAdmin = (String) session.getAttribute("uAdmin");
    model.addAttribute("uId", uId);
    model.addAttribute("uAdmin", uAdmin);
    List<CateVO> cvo = cateService.selectCateList();
    for (CateVO cateVO : cvo) {
        cateVO.setSubCate(cateService.selectCateUnList(cateVO));
    }
    model.addAttribute("categoryList", cvo);
        return "html/moda/product/productItem";
    }

    @GetMapping("/product/prodDetail.do")
    public String selectProdDetail(@RequestParam("code") String cod,int code, Model model, HttpSession session) {
        String uId = (String) session.getAttribute("uId");
        String uAdmin = (String) session.getAttribute("uAdmin");
        model.addAttribute("uId", uId);
        model.addAttribute("uAdmin", uAdmin);
        ProdVO rvo = prodService.selectProdOne(code);
        model.addAttribute("rvo", rvo);
        List<ReviewVO> reviewList = reviewService.findAllReview(cod);
        model.addAttribute("reviewList",reviewList);
        return "html/moda/product/productDetail";
    }
}
