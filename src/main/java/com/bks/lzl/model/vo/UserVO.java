package com.bks.lzl.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVO implements Serializable {
    private long id;

    private String username;

    private String userAccount;

    private String avatarUrl;

    private Integer gender;

    private String phone;

    private String email;

    private String tags;

    private Integer userStatus;

    private Date createTime;

    private Date updateTime;

    //0普通用户，1管理员
    private Integer userRole;

    private static final long serialVersionUID = 1L;
}