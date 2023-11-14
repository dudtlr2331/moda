package com.moda.moda.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSearch {        // Request
    private String uId;      // 로그인 아이디(PK)
    private String uPass;      // 비밀번호
    private String uName;    // 이름
    private String uEmail;   //이메일
    private Long uPost;    //우편 번호
    private String uAddr;    //집 주소
    private String uPhone;   //휴대폰 번호

    public void encodingPassword(PasswordEncoder passwordEncoder){
        if(StringUtils.isEmpty(uPass)){
            return;
        }
        uPass = passwordEncoder.encode(uPass);
    }
}
