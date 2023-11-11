package com.moda.adm.product;

import com.moda.cmm.FileRequest;
import com.moda.cmm.FileService;
import com.moda.cmm.FileUtils;
import com.moda.cmm.MessageDto;
import com.moda.moda.product.ProdVO;
import com.moda.moda.product.service.ProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdmProdController {
    private final ProdService prodService;
    private final FileService fileService;
    private final FileUtils fileUtils;

    // 신규 상품 등록
    @PostMapping("/adm/product/addProduct.do")
    public String addProduct(final ProdVO params, Model model) {
        int code = prodService.addProduct(params);
        List<FileRequest> files = fileUtils.uploadFiles(params.getFiles());
        fileService.saveFiles((long) code, files);
        MessageDto message = new MessageDto("상품 등록이 완료되었습니다.", "/adm/product/prodList.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 상품 작성 페이지
    @GetMapping("/adm/product/prodWrite.do")
    public String prodWrite(@RequestParam(name = "code", required = false, defaultValue = "0") final int code, Model model) {
        if (code != 0) {
            ProdVO pvo = prodService.selectProdOne(code);
            model.addAttribute("pvo", pvo);
        }
        return "html/adm/product/prodWrite";
    }

    // 상품 리스트
    @GetMapping("/adm/product/prodList.do")
    public String selectProdList(Model model, ProdVO pvo) {
        List<ProdVO> prodList = prodService.selectProdList(pvo);
        model.addAttribute("prodList", prodList);
        return "html/adm/product/productList";
    }

    // 상품 상세 페이지
    @GetMapping("/adm/product/prodView.do")
    public String openPostView(@RequestParam final int code, Model model) {
        ProdVO rvo = prodService.selectProdOne(code);
        model.addAttribute("rvo", rvo);
        return "html/adm/product/productView";
    }

    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "html/common/messageRedirect";
    }
}
