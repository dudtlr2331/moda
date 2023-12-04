package com.moda.adm.category;

import com.moda.adm.category.service.CateService;
import com.moda.adm.event.EventDto;
import com.moda.cmm.MessageDto;
import com.moda.moda.member.MemberVO;
import com.moda.moda.user.UserVO;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class AdmCateController {
    @Autowired
    private CateService cateService;

    // 카테고리 리스트 Ajax
    @RequestMapping(value ="/adm/cate/admCateListAjax.do")
    @ResponseBody
    public Map<String, Object> admCateListAjax(CateVO pvo) {
        Map<String, Object> data = new HashMap<>();
        List<Map<String, String>> jArry = new ArrayList<>();

        List<CateVO> underList = cateService.selectCateUnList(pvo);

        for (CateVO list : underList) {
            Map<String, String> obj = new HashMap<>();
            obj.put("catgryCd", list.getCatgryCd());
            obj.put("catgryNm", list.getCatgryNm());
            jArry.add(obj);
        }

        data.put("result", "success");
        data.put("dataList", jArry);

        return data;
    }

    // 카테고리 리스트
    @RequestMapping("/adm/cate/admCateList.do")
    public String admCateList(HttpServletRequest req, HttpServletResponse res, CateVO pvo) {
        List<CateVO> list = cateService.selectCateList(pvo);
        req.setAttribute("list", list);

        pvo.setUprClassCd(req.getParameter("catgryCd"));
        List<CateVO> underList = cateService.selectCateUnList(pvo);

        if(req.getParameter("catgryCd") != null) {
            req.setAttribute("underList", underList);
        }

        req.setAttribute("upperListSize", list.size());
        req.setAttribute("underListSize", underList.size());

        return "html/adm/category/category";
    }

    // 카테고리 생성 액션

    @RequestMapping("/adm/cate/admCateRegisterAct.do")
    public String admCateRegisterAct(HttpServletRequest req, HttpSession session, Model model) {
        // 세션에서 로그인 정보 가져오기
        MemberVO loginInfo = (MemberVO) session.getAttribute("loginInfo");
        System.out.println(req.getParameter("unUprClassCd"+ 1));
        System.out.println(req.getParameter("unUprClassCd"+ 2));

        List<CateVO> pvo = cateService.datainput(req , loginInfo.getUId(), "c101");


        for (CateVO cate : pvo) {
            cateService.saveCate(cate);
        }

        model.addAttribute("pvo", pvo);

        return "redirect:/adm/cate/admCateList.do";
    }
    // 카테고리 삭제 액션
    @RequestMapping("/adm/cate/admCateRemoveAct.do")
    public String admCateRemoveAct(@RequestParam("goodsCataSeq") final long seq) {
        cateService.deleteCate(seq);

        return "redirect:/adm/cate/admCateList.do";
    }
}