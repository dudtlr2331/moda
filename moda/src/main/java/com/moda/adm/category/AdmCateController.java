package com.moda.adm.category;

import com.moda.adm.category.service.CateService;
import com.moda.moda.user.UserVO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public JSONObject admCateListAjax(HttpServletRequest req, HttpServletResponse res, CateVO pvo) {
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
    public String admCateList(HttpServletRequest req, HttpServletResponse res, CateVO pvo) {
        List<CateVO> list = cateService.selectCateList(pvo);
        req.setAttribute("list", list);

        pvo.setUprClassCd(req.getParameter("catgryCd"));
        List<CateVO> underList = cateService.selectCateUnList(pvo);

        if (req.getParameter("catgryCd") != null) {
            req.setAttribute("underList", underList);
        }

        req.setAttribute("upperListSize", list.size());
        req.setAttribute("underListSize", underList.size());

        return "adm/cate/cate_list";
    }

    // 카테고리 생성 액션
    @RequestMapping("/adm/cate/admCateRegisterAct.do")
    public String admCateRegisterAct(HttpServletRequest req, HttpServletResponse res) {
        //세션
        HttpSession session = req.getSession();
        UserVO loginInfo = (UserVO) session.getAttribute("loginInfo");

        CateVO pvo = cateService.parameterSetting(req);
        pvo.setUpdtId(loginInfo.getUsrId());
        pvo.setRgstId(loginInfo.getUsrId());

        int result = cateService.saveCate(pvo);
        req.setAttribute("pvo", pvo);

        return "redirect:/adm/cate/admCateList.do";
    }

    // 카테고리 삭제 액션
    @RequestMapping("/adm/cate/admCateRemoveAct.do")
    public String admCateRemoveAct(HttpServletRequest req, HttpServletResponse res, CateVO pvo) {
        int result = cateService.deleteCate(pvo);

        return "redirect:/adm/cate/admCateList.do";
    }
}
