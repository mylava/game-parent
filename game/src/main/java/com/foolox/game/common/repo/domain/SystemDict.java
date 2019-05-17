package com.foolox.game.common.repo.domain;

import lombok.Data;

import java.util.Date;
@Data
public class SystemDict {
    private Long id;

    private String name;

    private String code;

    private Long parentId;

    private String config;

    private String memo;

    private Date createTime;
}