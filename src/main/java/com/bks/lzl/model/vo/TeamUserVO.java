package com.bks.lzl.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TeamUserVO implements Serializable {

    private static final long serialVersionUID = 1899063007109226944L;

    private Long id;

    private String name;

    private String description;

    private Integer maxNum;

    private String teamAvatar;

    private Date expireTime;

    private Long userId;

    //0公开，1私有，2加密
    private Integer status;

    private Date createTime;

    private Date updateTime;

    private UserVO createUser;

    private Integer hasJoinNum;

    private boolean hasJoin = false;
}
