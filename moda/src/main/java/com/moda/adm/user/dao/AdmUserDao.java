package com.moda.adm.user.dao;

import com.moda.adm.post.PostDto;
import com.moda.adm.user.AdmUserDto;
import com.moda.adm.user.AdmUserSearch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdmUserDao {

    List<AdmUserDto> findAll();

    AdmUserSearch findById(String id);

    void updateUser(AdmUserSearch params);
    void deleteUser(String id);
}