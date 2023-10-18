package com.moda.moda.user.service;

import com.moda.moda.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public class UserRepository {
    private UserVO pvo;

    List<UserVO> getUserList() {
        return pvo;
    }
    public List<UserVO> selectUserList(UserVO pvo){
        return mybatis.selectList("userDao.selectUserList", pvo);
    }
}
