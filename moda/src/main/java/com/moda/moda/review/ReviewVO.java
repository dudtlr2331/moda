package com.moda.moda.review;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ReviewVO {
    private long reNum;
    private long prodCode;
    private String uId;
    private String content;
    private String star;
    private String ordNo;
    private LocalDateTime rgsTime;
    private String reviewType;
}
