package com.moda.adm.category.service;

import com.moda.adm.category.CateVO;
import com.moda.adm.category.dao.CateDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

    public int saveCate(List<CateVO> pvo){
        try {
            for (CateVO cate : pvo) {
                if (cate.getUpCateType().equals("cateInsert")) {
                    catedao.insertCate(cate);
                } else {
                    catedao.updateCate(cate);
                }
            }
        } catch (Exception e) {
            return 0;
        }
        return 1;

    }
}
