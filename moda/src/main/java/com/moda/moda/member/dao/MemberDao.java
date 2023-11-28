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
    //아이디로 유저 정보 가져오기
    MemberVO findById(String uId);
    //회원 정보 수정
    void modMember(MemberVO memberVO);
    //회원 탈퇴
    void removeMember(String uid);
}
