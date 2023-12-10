package com.moda.moda.mypage;

import lombok.Data;

@Data
public class MypgVO {
    private String ordNo; /*주문번호*/
    private String ordrId; /*주문자 아이디*/
    private String ordrNm; /*주문자 이름*/
    private String ordrPhon; /*주문자 폰번호*/
    private Long payMny; /*결제금액*/
    private String ordStat; /*주문상태코드*/
    private String payWay; /*결제수단*/
    private String acqrNm; /*수령자 이름*/
    private String acqrPhon; /*수령자 휴대폰*/
    private String acqrAddr; /*수령지 주소*/
    private String acqrAddrDtl; /*수령지 상세 주소*/
    private String reqMemo; /*배송메모*/
    private int prodQty; /*수량*/
    private String prodImg; /*이미지 경로*/
    private String prodImgDtl; /*이미지 이름*/
    private int prodPrice; /*상품금액*/
    private String prodName;
    private String usrId;
    private String ordDate;
}
