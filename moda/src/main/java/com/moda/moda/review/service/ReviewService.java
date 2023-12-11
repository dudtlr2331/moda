package com.moda.moda.review.service;

import com.moda.moda.product.ProdVO;
import com.moda.moda.review.ReviewVO;

import java.util.List;

public interface ReviewService {
    List<ReviewVO> findAllReview(String prodCode);
    void orderUpdate(String ordNo);
    void createReview(ReviewVO rvo);
    ProdVO searchProdCode(String ordNo);
    boolean deleteReview(int reNum);
}
