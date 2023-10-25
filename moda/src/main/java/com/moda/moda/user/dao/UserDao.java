package com.moda.moda.user.dao;

import com.moda.moda.user.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<UserVO> selectUserList(UserVO pvo);
    int insertUser(UserVO pvo);
    UserVO userLogin(UserVO pvo);
}