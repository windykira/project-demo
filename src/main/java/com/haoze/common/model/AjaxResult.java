package com.haoze.common.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据基本信息。
 * @author maxl 2018-04-27。
 */
public class AjaxResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public AjaxResult() {
        put("code", 1);
        put("msg", "操作成功");
    }

    public static AjaxResult failure() {
        return failure(0, "操作失败");
    }

    public static AjaxResult failure(String msg) {
        return failure(500, msg);
    }

    public static AjaxResult failure(int code, String msg) {
        AjaxResult result = new AjaxResult();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static AjaxResult success(String msg) {
        AjaxResult result = new AjaxResult();
        result.put("msg", msg);
        return result;
    }

    public static AjaxResult success(Map<String, Object> map) {
        AjaxResult result = new AjaxResult();
        result.putAll(map);
        return result;
    }

    public static AjaxResult success() {
        return new AjaxResult();
    }

    @Override
    public AjaxResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
