package com.moda.moda.mypage.service;

import com.moda.moda.mypage.MypgVO;

import java.util.List;

public interface MypgService {
    List<MypgVO> selectMypgList(String usrId);
    MypgVO selectMypgDetail(String ordNo);
}
