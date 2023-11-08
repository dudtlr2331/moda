package com.moda.adm.user;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class AdmUserDto {
    private String uId;          //유저의 아이디
    private String uName;        //유저의 이름
    private String uEmail;       //유저의 이메일
    private String uPost;       //유저의 우편번호(5자리)
    private String uAddr;       //유저의 상세주소
    private String uPhone;       //유저의 연락처
    private LocalDateTime uDate;  //생성 일자
    private String uAdmin;       //권한
}