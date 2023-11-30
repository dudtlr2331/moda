package com.moda.adm.category;

import com.moda.adm.category.service.CateService;
import com.moda.cmm.MessageDto;
import com.moda.moda.user.UserVO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SuppressWarnings("unchecked")
public class AdmCateController {
    @Autowired
    private CateService cateService;

    // 카테고리 리스트 Ajax
    @RequestMapping("/adm/cate/admCateListAjax.do")
    @ResponseBody
    public JSONObject admCateListAjax(CateVO pvo) {
        JSONObject data = new JSONObject();
        JSONArray jArry = new JSONArray();

        List<CateVO> underList = cateService.selectCateUnList(pvo);

        for (int i = 0; i < underList.size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("catgryCd", underList.get(i).getCatgryCd());
            obj.put("catgryNm", underList.get(i).getCatgryNm());
            jArry.put(obj);
        }

        data.put("result", "success");
        data.put("dataList", jArry);

        return data;
    }

    // 카테고리 리스트
    @RequestMapping("/adm/cate/admCateList.do")
    public String admCateList(Model model, CateVO pvo) {
        List<CateVO> list = cateService.selectCateList(pvo);
        model.addAttribute("list", list);

        List<CateVO> underList = cateService.selectCateUnList(pvo);
        model.addAttribute("underList", underList);

        model.addAttribute("upperListSize", list.size());
        model.addAttribute("underListSize", underList.size());

        return "html/adm/category/category";
    }

    // 카테고리 생성 액션
    @RequestMapping("/adm/cate/admCateRegisterAct.do")
    public String admCateRegisterAct(HttpSession session, Model model, List<CateVO> pvo) {
        // 세션에서 로그인 정보 가져오기
        UserVO loginInfo = (UserVO) session.getAttribute("loginInfo");

        // Null 체크 추가
        if (loginInfo != null) {

            for (CateVO cate : pvo){
                cate.setRgstId(loginInfo.getUserId());
            }
            cateService.saveCate(pvo);
            model.addAttribute("pvo", pvo);
            return "redirect:/adm/cate/admCateList.do";
        } else {
            return "redirect:/login";
        }
    }
    // 카테고리 삭제 액션
    @RequestMapping("/adm/cate/admCateRemoveAct.do")
    public String admCateRemoveAct(@RequestParam("goodsCataSeq") final long seq) {
        cateService.deleteCate(seq);

        return "redirect:/adm/cate/admCateList.do";
    }
}