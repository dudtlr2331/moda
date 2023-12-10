package com.moda.moda.mypage.service;

import com.moda.moda.mypage.MypgVO;
import com.moda.moda.mypage.dao.MypgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MypgServiceImpl implements MypgService{
    @Autowired private MypgDao mypgDao;

    public List<MypgVO> selectMypgList(String usrId){
        return mypgDao.selectMypgList(usrId);
    };

    @Override
    public MypgVO selectMypgDetail(String ordNo) {
        return mypgDao.selectMypgDetail(ordNo);
    }
}
