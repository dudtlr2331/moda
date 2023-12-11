package com.moda.adm.category.service;

import com.moda.adm.category.CateVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public interface CateService {

    public CateVO selectCateOne(CateVO pvo);
    public List<CateVO> selectCateList();

    public List<CateVO> selectCateUnList(CateVO pvo);

    public int updateCate(CateVO pvo);

    public int deleteCate(final long seq);
    public int saveCate(CateVO pvo);
    public int deleteCateAll();
    public List<CateVO> datainput(HttpServletRequest req , String user);
}
