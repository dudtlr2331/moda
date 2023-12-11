package com.moda.moda.order;

import lombok.Data;

@Data
public class OrderVO {
    //주문 기본
    private String ordNo;//
    private String usrId;//
    private String ordStat;//
    private String ordrId;//
    private String ordrNm;//
    private String ordrPhon;//
    private String ordrEmail;//
    private String acqrPhon;//
    private String acqrNm;//
    private String acqrAddr;//
    private String acqrAddrDtl;//
    private String acqrEmail;//
    private String payWay;//
    private Long payMny;//
    private String reqMemo;
    private String ordDate;//
    private Long billNum;
    private int prodCode;//
    private String reviewYn;

    //주문 상세
    private int ordDtlNo;
    private String prodName;
    private int prodQty;


    //장바구니
    private int cartNum;
    private int cartAmount;
    private Long ordBasketSeq;
    private String useYn;
    private Long saleBoardSeq;
    private String prodImg;
    private String prodImgDtl;
    private String bulTitNm;
    private int prodPrice;
    private int prodDesc;
    private int saleCnt;
    private String saleStatCd;
    private String description;
    private String checkedList;
    private String key;
    private int dlvPrc;
    private String rvwTag;

    //상세페이지 상품 옵션
    private String colorOption;
    private String sizeOption;

    String[] goodsNmArry;
    Long[] goodsCdArry;
    int[] goodsQtyArry;
    private String[] saleBoardSeqs;
    private int index;

    //파라미터
    private String searchSaleBoardSeq;
}
