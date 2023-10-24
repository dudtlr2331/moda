package com.moda.moda.join.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class JoinDTO {
    private String id;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phone;
}
