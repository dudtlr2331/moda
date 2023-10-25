package com.moda.moda.user.service;

import com.moda.moda.user.UserVO;

import java.util.List;

public interface UserService {
        List<UserVO> selectUserList(UserVO pvo);
        void save(UserVO pvo);
        int insertUser(UserVO pvo);
        UserVO userLogin(UserVO pvo);
}
