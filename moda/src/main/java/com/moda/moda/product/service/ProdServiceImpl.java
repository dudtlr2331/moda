package com.moda.moda.product.service;

import com.moda.adm.category.CateVO;
import com.moda.moda.product.ProdVO;
import com.moda.moda.product.dao.ProdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ProdServiceImpl implements ProdService{
    private final ProdDao prodDao;

    @Autowired
    public ProdServiceImpl(ProdDao prodDao) {
        this.prodDao = prodDao;
    }


    @Override
    public int addProduct(ProdVO params) {
        prodDao.addProduct(params);
        return params.getProdCode();
    }

    @Override
    public List<ProdVO> selectProdList(ProdVO pvo) {
        return prodDao.selectProdList(pvo);
    }

    @Override
    public ProdVO selectProdOne(int code) {
        return prodDao.selectProdOne(code);
    }

    @Override
    public int updateProd(ProdVO params) {
        prodDao.updateProd(params);
        return params.getProdCode();
    }

    @Override
    public int deleteProd(int code) {
        prodDao.deleteProd(code);
        return code;
    }

    @Override
    public int addImagePath(ProdVO params) {
        prodDao.addImagePath(params);
        return params.getProdCode();
    }

    @Override
    public List<CateVO> findAllCate() {
        return prodDao.cateList();
    }

}
