package com.moda.moda.user;

import lombok.Data;

@Data
public class UserVO {
    private String userId;
    private String userPass;
    private String userName;
    private String userEmail;
    private String userPost;
    private String userAddr;
    private String userPhone;
    private String userDate;
    private String userAdmin;

    //카테고리 구현부
    String usrId;
}
