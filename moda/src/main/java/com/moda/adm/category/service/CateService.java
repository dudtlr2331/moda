package com.moda.adm.category.service;

import com.moda.adm.category.CateVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface CateService {



    public int deleteCate(CateVO pvo);
    public int saveCate(CateVO pvo);
    public List<CateVO> selectCateUnList(CateVO pvo);

    public List<CateVO> selectCateList(CateVO pvo);
    public CateVO parameterSetting(HttpServletRequest req);

    public void setIds(CateVO pvo, String userId);
}
