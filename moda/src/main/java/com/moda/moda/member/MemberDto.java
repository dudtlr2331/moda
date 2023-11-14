package com.moda.moda.member;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDto {           // Response
    private String uId;      // 로그인 아이디(PK)
    private String uPass;      // 비밀번호
    private String uName;    // 이름
    private String uEmail;   //이메일
    private Long uPost;    //우편 번호
    private String uAddr;    //집 주소
    private String uPhone;   //휴대폰 번호
    private LocalDateTime uDate;   // 회원 일자
    private String uAdmin;      //관리자 권한

    public void clearPassword(){
        this.uPass = "";
    }
}