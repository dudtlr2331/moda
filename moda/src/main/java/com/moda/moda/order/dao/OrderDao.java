package com.moda.moda.order.dao;

import com.moda.moda.order.OrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    //주문 기본
    int insertOrd(OrderVO pvo);
    OrderVO selectOrdOne(OrderVO pvo);
    List<OrderVO> selectOrdList(OrderVO pvo);
    int updateOrd(OrderVO pvo);
    int deleteOrd(OrderVO pvo);

    //주문 상세
    int insertOrdDtl(OrderVO pvo);
    OrderVO selectOrdDtlOne(OrderVO pvo);
    List<OrderVO> selectOrdDtlList(OrderVO pvo);
    int updateOrdDtl(OrderVO pvo);
    int deleteOrdDtl(OrderVO pvo);


    //장바구니
    int insertCart(OrderVO pvo);
    int deleteCart(OrderVO pvo);
    int updateCart(OrderVO pvo);
    List<OrderVO> selectCartList(OrderVO pvo);
    OrderVO ordCartSelect(OrderVO pvo);
    List<OrderVO> selectCartOrdDtlList(OrderVO pvo);
}
