package com.bks.lzl.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "user")
@Data
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private long id;

    private String username;

    private String userAccount;

    private String avatarUrl;

    private Integer gender;

    private String userPassword;

    private String phone;

    private String email;

    private String tags;

    private Integer userStatus;

    private Date createTime;

    private Date updateTime;

    @TableLogic
    private Integer isDelete;

    //0普通用户，1管理员
    private Integer userRole;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}