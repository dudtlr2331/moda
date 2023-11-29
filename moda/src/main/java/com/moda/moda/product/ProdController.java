package com.moda.moda.product;

import com.moda.moda.product.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProdController {
    private final ProdService prodService;

    @Autowired
    public ProdController(ProdService prodService) {
        this.prodService = prodService;
    }

    @GetMapping("/product/prodList")
    public String selectProdList(ProdVO pvo) {
        List<ProdVO> prodList = prodService.selectProdList(pvo);
        System.out.println(prodList);

        return "html/moda/main/main";
    }

    @GetMapping("/product/prodDetail.do")
    public String selectProdDetail(int code, Model model) {
        ProdVO rvo = prodService.selectProdOne(code);
        model.addAttribute("rvo", rvo);
        return "html/moda/product/productDetail";
    }
}
