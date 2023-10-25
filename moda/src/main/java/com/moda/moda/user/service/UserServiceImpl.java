package com.moda.moda.user.service;

import com.moda.moda.user.UserVO;
import com.moda.moda.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
        private final UserDao userDao;

        @Autowired
        public UserServiceImpl(UserDao userDao) {
                this.userDao = userDao;
        }

        @Override
        public void save(UserVO pvo) {

        }

        @Override
        public int insertUser(UserVO pvo) {
                return userDao.insertUser(pvo);
        }

        @Override
        public UserVO userLogin(UserVO pvo) {
                System.out.println(pvo);
                return userDao.userLogin(pvo);
        }

        @Override
        public List<UserVO> selectUserList(UserVO pvo) {
                // UserDao를 이용하여 사용자 데이터를 가져옵니다.
                return userDao.selectUserList(pvo);
        }



}
