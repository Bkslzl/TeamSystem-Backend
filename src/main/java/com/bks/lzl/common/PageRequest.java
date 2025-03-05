package com.bks.lzl.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageRequest implements Serializable {

    private static final long serialVersionUID = -5860707094194210842L;

    protected int pageSize = 10;

    protected int pageNum = 1;
}
