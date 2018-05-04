package com.haoze;

import com.github.pagehelper.Page;
import com.haoze.common.model.QueryParam;
import com.haoze.model.system.UserEntity;
import com.haoze.service.system.UserService;
import com.haoze.utils.JsoupUtil;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDemoApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {

        Map<String, Object> params = new HashMap();
        //userService.list(params);
        Page<UserEntity> sysUserList = userService.listByPage(2, 10);
        assert sysUserList != null;
        /*String str = "36.2℃P98次/分R20次/分BP96/66mmHg";
		String newStr = Pattern.compile("[^0-9./℃]").matcher(str).replaceAll("")
				.replace("℃",",").replace("/",",");
		assert newStr != null;*/
    }

    @Test
    public void testJsoup() throws IOException {

        String strCity = URLEncoder.encode("常州", "GB2312");
        String url = "http://php.weather.sina.com.cn/xml.php?city=" + strCity + "&password=DJOYnieT8234jlsK&day=0";
        Connection.Response response = JsoupUtil.sendHttpGetRequest(url,"",null);
        assert response != null;
    }

}
