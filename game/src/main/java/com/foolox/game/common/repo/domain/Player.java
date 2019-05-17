package com.foolox.game.common.repo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Player {
    private String id;

    private String username;

    private String password;

    private String email;

    private String gender;

    private String nickname;

    private String userType;

    private String mobile;

    private String headimg;

    private Integer state;

    private Long balance;

    private String sign;

    private String inviteCode;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;

    private String memo;

    private Date deactiveTime;

    private String openid;

    private Byte disabled;
}