package com.moda.moda.product.service;

import com.moda.moda.product.ProdVO;

import java.util.List;

public interface ProdService {
    int addProduct(final ProdVO params);
    List<ProdVO> selectProdList(ProdVO pvo);
    ProdVO selectProdOne(int code);
    int updateProd(final ProdVO params);
    int deleteProd(final int code);
    int addImagePath(ProdVO params);
}
