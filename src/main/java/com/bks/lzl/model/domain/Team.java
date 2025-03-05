package com.bks.lzl.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName(value = "team")
@Data
public class Team implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Integer maxNum;

    private String teamAvatar;

    private Date expireTime;

    private Long userId;

    //0公开，1私有，2加密
    private Integer status;

    private String password;

    private Date createTime;

    private Date updateTime;

    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}