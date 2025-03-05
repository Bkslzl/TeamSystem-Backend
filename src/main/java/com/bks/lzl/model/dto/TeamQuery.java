package com.bks.lzl.model.dto;

import com.bks.lzl.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TeamQuery extends PageRequest {
    private Long id;

    private List<Long> idList;

    private String searchText;

    private String name;

    private String description;

    private Integer maxNum;

    private Long userId;

    //0公开，1私有，2加密
    private Integer status;
}
