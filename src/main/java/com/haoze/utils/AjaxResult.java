package com.haoze.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by haoz-dev4 on 2018/4/27.
 */
public class AjaxResult extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public AjaxResult() {
        put("code", 0);
        put("msg", "操作成功");
    }

    public static AjaxResult error() {
        return error(1, "操作失败");
    }

    public static AjaxResult error(String msg) {
        return error(500, msg);
    }

    public static AjaxResult error(int code, String msg) {
        AjaxResult result = new AjaxResult();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static AjaxResult ok(String msg) {
        AjaxResult result = new AjaxResult();
        result.put("msg", msg);
        return result;
    }

    public static AjaxResult ok(Map<String, Object> map) {
        AjaxResult result = new AjaxResult();
        result.putAll(map);
        return result;
    }

    public static AjaxResult ok() {
        return new AjaxResult();
    }

    @Override
    public AjaxResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
