package com.moda.adm.user.service;

import com.moda.adm.user.AdmUserDto;
import com.moda.adm.user.AdmUserSearch;

import java.util.List;

public interface AdmUserService {
    public List<AdmUserDto> findAllUser();
    public String deleteUser(final String id);
    public AdmUserSearch findUserById(final String id);
    public String updateUser(final AdmUserSearch params);
}