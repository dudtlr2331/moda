package com.moda.adm.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AdmUserSearch {
    private String uId;      // PK
    private String uName;    // 이름
    private String uEmail;   //이메일
    private String uPost;    //우편 번호
    private String uAddr;    //집 주소
    private String uPhone;   //휴대폰 번호
    private LocalDateTime uDate;   // 회원 일자
    private String uAdmin;   // 권한
}