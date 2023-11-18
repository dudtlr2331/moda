package com.moda.moda.main.dao;

import com.moda.moda.main.MainVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainDao {
    public List<MainVO> selectListMainHome();
}
