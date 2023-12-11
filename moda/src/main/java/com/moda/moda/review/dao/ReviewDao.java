package com.moda.moda.review.dao;

import com.moda.moda.product.ProdVO;
import com.moda.moda.review.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReviewDao {
    void orderUpdate(String ordNo);
    void createReview(ReviewVO rvo);

    ProdVO searchProdCode(String ordNo);
    List<ReviewVO> findAll(String prodCode);
    void deleteReview(int reNum);
}
