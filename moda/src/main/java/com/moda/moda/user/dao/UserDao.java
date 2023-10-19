package com.moda.moda.user.dao;

import com.moda.moda.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public class UserDao {
    @Autowired
    private SqlSessionTemplate mybatis;
    private UserVO pvo;

    public List<UserVO> selectUserList(UserVO pvo){
        return mybatis.selectList("userDao.selectUserList", pvo);
    }
}
