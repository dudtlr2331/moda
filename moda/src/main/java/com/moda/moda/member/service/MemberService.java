package com.moda.moda.member.service;

import com.moda.moda.member.MemberVO;
import com.moda.moda.member.dao.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MemberService {
    @Autowired
    MemberDao memberDao;

    //회원 가입 및 회원 수정 시 시간구하기
    SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    @Transactional
    public void joinMember(MemberVO memberVO){        //회원가입 서비스
        memberVO.setUDate(localTime);
        if(memberVO.getUPost().isEmpty()){
            memberVO.setUPost(null);
        }
        if(memberVO.getUAddr().isEmpty()){
            memberVO.setUAddr(null);
        }
        if(memberVO.getUPhone().isEmpty()){
            memberVO.setUPhone(null);
        }
        memberDao.saveMember(memberVO);
    }

    @Transactional
    public int checkDuplicate(String uId){          //아이디 중복 검사 서비스
        return memberDao.countById(uId);
    }

    @Transactional
    public int loginMember(MemberVO memberVO){          //로그인 서비스
        return memberDao.matchMember(memberVO);
    }

    @Transactional
    public MemberVO findByMember(String uId){          //id로 멤버 정보 가져오는 서비스
        return memberDao.findById(uId);
    }

    @Transactional
    public void editMember(MemberVO memberVO){          //회원 수정 서비스
        if(memberVO.getUPost().isEmpty()){
            memberVO.setUPost(null);
        }
        if(memberVO.getUAddr().isEmpty()){
            memberVO.setUAddr(null);
        }
        if(memberVO.getUPhone().isEmpty()){
            memberVO.setUPhone(null);
        }
        memberDao.modMember(memberVO);
    }
}
