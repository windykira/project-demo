package com.haoze.common.model;


import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页封装信息。
 * @author maxl
 * @time 2018-05-03。
 */
public class PaginationResult<T> implements Serializable {

    private int total;
    private Page<T> pageResult;

    public PaginationResult(Page<T> pageResult, int total) {
        this.pageResult = pageResult;
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Page<T> getPageResult() {
        return pageResult;
    }

    public void setPageResult(Page<T> pageResult) {
        this.pageResult = pageResult;
    }
}
