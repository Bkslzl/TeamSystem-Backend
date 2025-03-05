package com.bks.lzl.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TeamUpdateRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private Long id;

    private String name;

    private String description;

    private String teamAvatar;

    private Date expireTime;

    //0公开，1私有，2加密
    private Integer status;

    private String password;
}