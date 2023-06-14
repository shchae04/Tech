package com.dh.tech.domain.member;

import lombok.Data;

import javax.management.relation.Role;

@Data
public class Member {

    private Long id;
    private String userName;
    private String loginId;
    private String password;
    private String memberRoles;



}
