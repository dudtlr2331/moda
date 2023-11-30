package com.moda.adm.category.dao;

import com.moda.adm.category.CateVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CateDao {
    public int insertCate(CateVO pvo);

    public CateVO selectCateOne(CateVO pvo);

    public List<CateVO> selectCateList(CateVO pvo);

    public List<CateVO> selectCateUnList(CateVO pvo);

    public int updateCate(CateVO pvo);

    public int deleteCate(final long seq);

    public int deleteCateAll();
}
