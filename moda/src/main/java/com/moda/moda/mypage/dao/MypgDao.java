package com.moda.moda.mypage.dao;

import com.moda.moda.mypage.MypgVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypgDao {
    List<MypgVO> selectMypgList(String usrId);
    MypgVO selectMypgDetail(String ordNo);
}
