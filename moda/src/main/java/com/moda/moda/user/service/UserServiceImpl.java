package com.moda.moda.user.service;

import com.moda.moda.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
        @Autowired
        private UserRepository UserRepository;

        @Override
        public List<UserVO> getAllMember(){
            return UserRepository.getVoList();
        }
}
