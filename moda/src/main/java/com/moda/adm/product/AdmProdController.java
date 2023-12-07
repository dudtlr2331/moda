package com.moda.adm.product;

import com.moda.adm.category.CateVO;
import com.moda.cmm.*;
import com.moda.moda.product.ProdVO;
import com.moda.moda.product.service.ProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

@Controller
@RequiredArgsConstructor
public class AdmProdController {
    private final ProdService prodService;
    private final FileService fileService;
    private final FileUtils fileUtils;

    // 신규 상품 등록
    @PostMapping("/adm/product/addProduct.do")
    public String addProduct(final ProdVO params, Model model) {
        //상품 등록
        int code = prodService.addProduct(params);

        // 파일 업로드 및 파일 정보 저장
        List<FileRequest> files = fileUtils.uploadFiles(params.getFiles());
        fileService.saveFiles((long) code, "product", files);

        // 파일 경로 가져오기
        String filePath = files.stream()
                .findFirst() // 파일이 여러 개일 경우 첫 번째 파일의 경로를 가져옴
                .map(FileRequest::getFilePath)
                .orElse(""); ///images/part/bag/backpack/backpack_01.jpg

        // File.separator를 기준으로 경로를 나누기
        String[] pathSegments = filePath.split(Pattern.quote("images" + File.separator));

        // 변수에 저장
        String[] imgPathSegments = pathSegments[1].split(Pattern.quote(File.separator));
        String prodImg = "/images/" + imgPathSegments[0];  // 수정
        String prodImgDtl = "/" + imgPathSegments[1];      // 수정

        params.setProdImg(prodImg);
        params.setProdImgDtl(prodImgDtl);

        // 파일 경로 저장
        prodService.addImagePath(params);

        // 상품 등록 완료 메시지
        MessageDto message = new MessageDto("상품 등록이 완료되었습니다.", "/adm/product/prodList.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 상품 작성 페이지
    @GetMapping("/adm/product/prodWrite.do")
    public String prodWrite(@RequestParam(name = "code", required = false, defaultValue = "0") final int code, Model model) {
        if (code != 0) {
            ProdVO pvo = prodService.selectProdOne(code);
            model.addAttribute("pvo", pvo);
            List<CateVO> cvo = prodService.findAllCate();
            model.addAttribute("cvo", cvo);
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

    // 상품 수정
    @PostMapping("/adm/product/updateProd.do")
    public String updateProd(final ProdVO params,Model model) {

        // 1. 게시글 정보 수정
        prodService.updateProd(params);

        // 2. 파일 업로드 (to disk)
        List<FileRequest> uploadFiles = fileUtils.uploadFiles(params.getFiles());

        // 3. 파일 정보 저장 (to database)
        fileService.saveFiles((long) params.getProdCode(), "product", uploadFiles);

        // 4. 삭제할 파일 정보 조회 (from database)
        List<FileResponse> deleteFiles = fileService.findAllFileByIds(params.getRemoveFileIds());

        // 5. 파일 삭제 (from disk)
        fileUtils.deleteFiles(deleteFiles);

        // 6. 파일 삭제 (from database)
        fileService.deleteAllFileByIds(params.getRemoveFileIds());

        MessageDto message = new MessageDto("상품 수정이 완료되었습니다.", "/adm/product/prodList.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 상품 삭제
    @PostMapping("/adm/product/deleteProd.do")
    public String deletePost(@RequestParam final int code, Model model) {
        prodService.deleteProd(code);
        MessageDto message = new MessageDto("상품 삭제가 완료되었습니다.", "/adm/product/prodList.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    // 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
    private String showMessageAndRedirect(final MessageDto params, Model model) {
        model.addAttribute("params", params);
        return "html/common/messageRedirect";
    }
}
