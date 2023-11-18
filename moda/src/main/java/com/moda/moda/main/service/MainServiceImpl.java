package com.moda.moda.main.service;

import com.moda.moda.main.MainVO;
import com.moda.moda.main.dao.MainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    private final MainDao mainDao;

    @Autowired
    public MainServiceImpl(MainDao mainDao) {
        this.mainDao = mainDao;
    }

    @Override
    public List<MainVO> selectListMainHome() {
        return mainDao.selectListMainHome();
    }
}
