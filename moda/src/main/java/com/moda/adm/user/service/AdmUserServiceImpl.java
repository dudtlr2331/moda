package com.moda.adm.user.service;

import com.moda.adm.user.AdmUserDto;
import com.moda.adm.user.AdmUserSearch;
import com.moda.adm.user.dao.AdmUserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdmUserServiceImpl implements AdmUserService {
    private final AdmUserDao admUserDao;

    public List<AdmUserDto> findAllUser() {
        return admUserDao.findAll();
    }


    public String deleteUser(String id) {
        admUserDao.deleteUser(id);
        return id;
    }


    public AdmUserSearch findUserById(final String id) {
        return admUserDao.findById(id);
    }


    public String updateUser(final AdmUserSearch params) {
        admUserDao.updateUser(params);
        return params.getUId();
    }


}
