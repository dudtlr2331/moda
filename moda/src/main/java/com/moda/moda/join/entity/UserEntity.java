package com.moda.moda.join.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "users")
public class UserEntity {

    @Id
    private String u_id;

    @Column
    private String u_pass;

    @Column
    private String u_name;

    @Column
    private String u_email;

    @Column
    private int u_post;

    @Column
    private String u_addr;

    @Column
    private String u_phone;

    @Column
    private String u_date;

    @Column
    private String u_admin;
}
