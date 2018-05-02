package com.haoze.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties配置文件操作工具。
 * @author maxl 2018-05-02
 */
public class SystemConfigUtil {

    public static String getProperty(String key){

        Properties properties = new Properties();
        InputStream inputStream = SystemConfigUtil.class.getClassLoader().getResourceAsStream("env.properties");
        try {
            properties.load(inputStream);
            return (String) properties.get(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
