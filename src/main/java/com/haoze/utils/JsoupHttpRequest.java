package com.haoze.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

/**
 * 构建Http请求工具。
 * @author maxl
 * @time 2018-05-04。
 */
public class JsoupHttpRequest {

    public static Connection.Response sendHttpGetRequest(String url, String cookie, Map<String, Object> dataMap) throws IOException {

        Connection con = Jsoup.connect(url);
        con.header("Accept", "text/html, application/xhtml+xml, */*");
        con.header("Content-Type", "application/x-www-form-urlencoded");
        if (StringUtils.isNotEmpty(cookie)) {
            con.header("Cookie", cookie);
        }
        con.timeout(3000);
        if (dataMap != null) {
            for (Map.Entry<String, Object> map : dataMap.entrySet()) {
                con.data(map.getKey(), String.valueOf(map.getValue()));
            }
        }
        Connection.Response response = con.ignoreContentType(true).execute();
        String body = response.body();
        return response;
    }

    public static Object sendHttpPostRequest(String url, Map<String, Object> dataMap) throws IOException {
        Connection con = Jsoup.connect(url);
        if (dataMap != null) {
            for (Map.Entry<String, Object> map : dataMap.entrySet()) {
                con.data(map.getKey(), String.valueOf(map.getValue()));
            }
        }
        Connection.Response response = con.method(Connection.Method.POST).timeout(3000).execute();
        return response;
    }
}
