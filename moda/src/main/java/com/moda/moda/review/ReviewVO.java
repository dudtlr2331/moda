package com.moda.moda.review;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewVO {
    private long reNum;
    private long prodCode;
    private String uId;
    private String content;
    private String star;
    private String ordNo;
}
