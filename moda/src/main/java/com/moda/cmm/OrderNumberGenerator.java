package com.moda.cmm;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNumberGenerator {

    // 주문 번호를 생성하는 메서드
    public static String generateOrderNumber() {
        // 현재 날짜 및 시간을 기반으로 주문 번호 생성
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());

        // 예시: "ORD_20211207123456" 형태로 생성
        return "ORD_" + timestamp;
    }

    public static void main(String[] args) {
        // 주문 번호 생성 예시
        String orderNumber = generateOrderNumber();
        System.out.println("Generated Order Number: " + orderNumber);
    }
}