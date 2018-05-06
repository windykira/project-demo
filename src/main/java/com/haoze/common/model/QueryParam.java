package com.haoze.common.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数。
 * @author maxl
 * @time 2018-04-27。
 */
public class QueryParam extends LinkedHashMap<String, Object> {

    private static final long serialVersionUID = 1L;
    private int offset;
    private int limit;
    private int page;

    public QueryParam(Map<String, Object> params) {
        this.putAll(params);
        // 分页参数
        this.offset = Integer.parseInt(params.get("offset").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        this.page = Integer.parseInt(params.get("pageSize").toString());
        this.put("offset", offset);
        this.put("page", offset / limit + 1);
        this.put("limit", limit);
    }

    public int getPage() {
        return page;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.put("offset", offset);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
