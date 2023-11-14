package com.moda.moda.member.service;

import com.moda.moda.member.MemberDto;
import com.moda.moda.member.MemberSearch;
import com.moda.moda.member.dao.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원 정보 저장 (회원가입)
     * @param params - 회원 정보
     * @return PK
     */
    @Transactional
    public String saveMember(final MemberSearch params) {
        params.encodingPassword(passwordEncoder);
        memberDao.save(params);
        return params.getUId();
    }

    /**
     * 회원 상세정보 조회
     * @param uId - UK
     * @return 회원 상세정보
     */
    public MemberDto findMemberById(final String uId) {
        return memberDao.findById(uId);
    }

    /**
     * 회원 정보 수정
     * @param params - 회원 정보
     * @return PK
     */
    @Transactional
    public String updateMember(final MemberSearch params) {
        params.encodingPassword(passwordEncoder);
        memberDao.update(params);
        return params.getUId();
    }

    /**
     * 회원 정보 삭제 (회원 탈퇴)
     * @param uId - PK
     * @return PK
     */
    @Transactional
    public String deleteMemberById(final String uId) {
        memberDao.deleteById(uId);
        return uId;
    }


    /**
     * 회원 수 카운팅 (ID 중복 체크)
     * @param uId - UK
     * @return 회원 수
     */
    public int countMemberByLoginId(final String uId) {
        return memberDao.chkByLoginId(uId);
    }
}
