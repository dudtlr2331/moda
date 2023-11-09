package com.moda.moda.product.service;

import com.moda.adm.post.PostDto;
import com.moda.adm.post.PostSearch;
import com.moda.moda.product.ProdVO;

import java.util.List;

public interface ProdService {
    public int addProduct(final ProdVO params);
    List<ProdVO> selectProdList(ProdVO pvo);
    ProdVO selectProdOne(int code);
    public int updateProd(final ProdVO params);
    public int deleteProd(final int code);
}