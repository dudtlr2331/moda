package com.moda.adm.category.service;

import com.moda.adm.category.CateVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Service
public class CateServiceImpl implements CateService{
    @Override
    public int deleteCate(CateVO pvo) {
        return 0;
    }

    @Override
    public int saveCate(CateVO pvo) {
        return 0;
    }

    @Override
    public List<CateVO> selectCateUnList(CateVO pvo) {
        return null;
    }

    @Override
    public List<CateVO> selectCateList(CateVO pvo) {
        return null;
    }

    @Override
    public CateVO parameterSetting(HttpServletRequest req) {
        CateVO pvo = new CateVO();

        // HttpServletRequest에서 필요한 정보 추출
        String catgryCd = req.getParameter("catgryCd");
        String catgryNm = req.getParameter("catgryNm");
        // 다른 필요한 정보들...

        // CateVO에 값 설정
        pvo.setCatgryCd(catgryCd);
        pvo.setCatgryNm(catgryNm);
        // 다른 필드들 설정...

        return pvo;
    }

    @Override
    public void setIds(CateVO pvo, String userId) {

    }
}
