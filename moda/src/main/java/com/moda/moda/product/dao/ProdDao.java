package com.moda.moda.product.dao;

import com.moda.adm.category.CateVO;
import com.moda.moda.product.ProdVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProdDao {
    void addProduct(ProdVO params);
    List<ProdVO> selectProdList(ProdVO pvo);
    ProdVO selectProdOne(int code);
    int updateProd(ProdVO params);
    int deleteProd(int code);
    int addImagePath(ProdVO params);
    List<ProdVO> selectProdCate(String cateCode);
    List<CateVO> cateList();
}
