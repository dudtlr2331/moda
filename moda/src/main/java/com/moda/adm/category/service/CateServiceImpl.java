package com.moda.adm.category.service;

import com.moda.adm.category.CateVO;
import com.moda.adm.category.dao.CateDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CateServiceImpl implements CateService{

    private final CateDao catedao;
    public CateVO selectCateOne(CateVO pvo) {
        return catedao.selectCateOne(pvo);
    }

    public List<CateVO> selectCateList(CateVO pvo){
        return catedao.selectCateList(pvo);
    }

    public List<CateVO> selectCateUnList(CateVO pvo){
        return catedao.selectCateUnList(pvo);
    }

    public int updateCate(CateVO pvo) {
        return catedao.updateCate(pvo);
    }

    public int deleteCate(final long seq) {
        return catedao.deleteCate(seq);
    }

    public int deleteCateAll() {
        return catedao.deleteCateAll();
    }

    @Override
    public List<CateVO> datainput(HttpServletRequest req  , String user) {
        List<CateVO> pvo = new ArrayList<>();
        int upperTxtCnt = req.getParameter("upperTxtCnt") == null? 0 : Integer.parseInt(req.getParameter("upperTxtCnt"));
        int underTxtCnt = req.getParameter("underTxtCnt") == null? 0 : Integer.parseInt(req.getParameter("underTxtCnt"));

        for(int i =0 ; i <= upperTxtCnt ; i++){
            CateVO cate = new CateVO();
            cate.setRgstId(user);
            cate.setGoodsCataSeq(req.getParameter("upGoodsCataSeq"+i));
            cate.setCateType(req.getParameter("upCateType"+i));
            cate.setUseYn(req.getParameter("upUseYn"+i));
            cate.setCatgryNm(req.getParameter("upCatgryNm"+i));
            cate.setCatgryCd(req.getParameter("upCatgryCd"+i));
            cate.setClassLvlCd("1");
            cate.setNoteCont(req.getParameter("upNoteCont"+i));
            pvo.add(cate);
        }

        for(int i =0 ; i <= underTxtCnt ; i++){
            CateVO cate = new CateVO();
            cate.setRgstId(user);
            cate.setGoodsCataSeq(req.getParameter("unGoodsCataSeq"+i));
            cate.setCateType(req.getParameter("unCateType"+i));
            cate.setUseYn(req.getParameter("unUseYn"+i));
            cate.setCatgryNm(req.getParameter("unCatgryNm"+i));
            cate.setCatgryCd(req.getParameter("unCatgryCd"+i));
            cate.setClassLvlCd("2");
            cate.setNoteCont(req.getParameter("unNoteCont"+i));
            cate.setUprClassCd(req.getParameter("unUprClassCd"+i));
            pvo.add(cate);
        }

        return pvo;
    }

    public int saveCate(CateVO pvo){
        try{
                if (pvo.getCateType().equals("cateInsert")) {
                    pvo.setRgstDate(LocalDateTime.now());
                    catedao.insertCate(pvo);
                } else {
                    catedao.updateCate(pvo);
                }
        } catch (Exception e) {
            return 0;
        }
        return 1;

    }
}
