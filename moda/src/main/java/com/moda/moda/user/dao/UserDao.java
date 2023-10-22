package com.moda.moda.user.dao;

import com.moda.moda.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public class UserDao {
    @Autowired
    private SqlSessionTemplate mybatis;

    public List<UserVO> selectUserList(UserVO pvo){
        return mybatis.selectList("userDao.selectUserList", pvo);
    }
}