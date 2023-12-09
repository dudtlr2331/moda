package com.moda.moda.order.service;

import com.moda.moda.order.OrderVO;

import java.util.List;

public interface OrderService {
    //주문 기본
    int insertOrd(OrderVO pvo); // 주문 데이터 추가
    OrderVO selectOrdOne(OrderVO pvo); // 주문 1건 가져오기
    List<OrderVO> selectOrdList(OrderVO pvo); // 주문 리스트 가져오기
    int updateOrd(OrderVO pvo); // 주문 업데이트
    int deleteOrd(OrderVO pvo); // 주문 삭제

    //주문 상세
    int insertOrdDtl(OrderVO pvo); // 주문 데이터 추가
    OrderVO selectOrdDtlOne(OrderVO pvo); // 주문 1건 가져오기
    List<OrderVO> selectOrdDtlList(OrderVO pvo); // 주문 리스트 가져오기
    int updateOrdDtl(OrderVO pvo); // 주문 업데이트
    int deleteOrdDtl(OrderVO pvo); // 주문 삭제

    int insertCart(OrderVO pvo);
    int deleteCart(OrderVO pvo);
    int updateCart(OrderVO pvo);
    List<OrderVO> selectCartList(OrderVO pvo);
    OrderVO ordCartSelect(OrderVO pvo);
    List<OrderVO> selectCartOrdDtlList(OrderVO pvo);
    int insertCartOrdDtl(OrderVO pvo);
}
