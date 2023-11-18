package com.moda.moda.member.dao;

import com.moda.moda.member.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    //회원가입
    void saveMember(MemberVO memberVO);
    //아이디 중복 검사
    int countById(String uId);
    //로그인
    int matchMember(MemberVO memberVO);

    MemberVO findById(String uId);
}
