package com.haoze.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties配置文件操作工具。
 * @author maxl 2018-05-02
 */
public class SystemConfigParseUtil {

    public static String getProperty(String key) throws IOException {

        Properties properties = new Properties();
        InputStream inputStream = SystemConfigParseUtil.class.getClassLoader().getResourceAsStream("env.properties");
        properties.load(inputStream);
        return (String) properties.get(key);
    }
}