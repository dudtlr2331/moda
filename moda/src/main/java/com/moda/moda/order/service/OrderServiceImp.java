package com.moda.moda.order.service;

import com.moda.moda.order.OrderVO;
import com.moda.moda.order.dao.OrderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService{
    @Autowired OrderDao orderDao;

    //주문 기본
    @Override
    public int insertOrd(OrderVO pvo) {
        orderDao.insertOrd(pvo);
        return 1;
    }

    @Override
    public OrderVO selectOrdOne(OrderVO pvo) {
        return orderDao.selectOrdOne(pvo);
    }

    @Override
    public List<OrderVO> selectOrdList(OrderVO pvo) {
        return orderDao.selectOrdList(pvo);
    }

    @Override
    public int updateOrd(OrderVO pvo) {
        orderDao.updateOrd(pvo);
        return 0;
    }

    @Override
    public int deleteOrd(OrderVO pvo) {
        orderDao.deleteOrd(pvo);
        return 0;
    }

    //주문 상세
    @Override
    public int insertOrdDtl(OrderVO pvo) {
        orderDao.insertOrdDtl(pvo);
        return 1;
    }

    @Override
    public OrderVO selectOrdDtlOne(OrderVO pvo) {
        return orderDao.selectOrdDtlOne(pvo);
    }

    @Override
    public List<OrderVO> selectOrdDtlList(OrderVO pvo) {
        return orderDao.selectOrdDtlList(pvo);
    }

    @Override
    public int updateOrdDtl(OrderVO pvo) {
        orderDao.updateOrdDtl(pvo);
        return 0;
    }

    @Override
    public int deleteOrdDtl(OrderVO pvo) {
        orderDao.deleteOrdDtl(pvo);
        return 0;
    }

    //장바구니

    @Override
    public int insertCart(OrderVO pvo) {
        return 0;
    }

    @Override
    public int deleteCart(OrderVO pvo) {
        return 0;
    }

    @Override
    public int updateCart(OrderVO pvo) {
        return 0;
    }

    @Override
    public List<OrderVO> selectCartList(OrderVO pvo) {
        return orderDao.selectCartList(pvo);
    }

    @Override
    public OrderVO ordCartSelect(OrderVO pvo) {
        return null;
    }

    @Override
    public List<OrderVO> selectCartOrdDtlList(OrderVO pvo) {
        return null;
    }

    @Override
    public int insertCartOrdDtl(OrderVO pvo) {
        return 0;
    }
}
