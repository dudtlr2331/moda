package com.moda.moda.member.dao;

import com.moda.moda.member.MemberDto;
import com.moda.moda.member.MemberSearch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    /**
     * 회원 정보 저장 (회원가입)
     * @param params - 회원 정보
     */
    void save(MemberSearch params);

    /**
     * 회원 상세정보 조회
     * @param uId - UK
     * @return 회원 상세정보
     */
    MemberDto findById(String uId);

    /**
     * 회원 정보 수정
     * @param params - 회원 정보
     */
    void update(MemberSearch params);

    /**
     * 회원 정보 삭제 (회원 탈퇴)
     * @param uId - PK
     */
    void deleteById(String uId);

    /**
     * 회원 수 카운팅 (ID 중복 체크)
     * @param uId - UK
     * @return 회원 수
     */
    int chkById(String uId);
}