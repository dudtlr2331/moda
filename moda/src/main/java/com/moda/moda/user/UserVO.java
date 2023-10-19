package com.moda.moda.user;

import lombok.Data;

@Data
public class UserVO {
    private long userBaseSeq;
    private String userId;
    private String userNm;
    private String passWd;
}
