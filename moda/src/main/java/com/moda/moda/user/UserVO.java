package com.moda.moda.user;

import lombok.Data;

@Data
public class UserVO {
    private long usrBaseSeq;
    private String userId;
    private String userNm;
    private String passWd;
}
