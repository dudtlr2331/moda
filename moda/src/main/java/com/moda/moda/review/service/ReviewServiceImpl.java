package com.moda.moda.review.service;

import com.moda.moda.product.ProdVO;
import com.moda.moda.review.ReviewVO;
import com.moda.moda.review.dao.ReviewDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewDao reviewDao;
    @Override
    public List<ReviewVO> findAllReview() {
        return reviewDao.findAll();
    }

    @Override
    public void orderUpdate(String ordNo) {
    reviewDao.orderUpdate(ordNo);
    }

    @Override
    public void createReview(ReviewVO rvo) {
        rvo.setProdCode(searchProdCode(rvo.getOrdNo()).getProdCode());
        orderUpdate(rvo.getOrdNo());

    reviewDao.createReview(rvo);
    }

    @Override
    public ProdVO searchProdCode(String ordNo) {
        return reviewDao.searchProdCode(ordNo);
    }
}