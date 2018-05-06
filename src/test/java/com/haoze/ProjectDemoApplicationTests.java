package com.haoze;

import com.github.pagehelper.Page;
import com.haoze.model.system.entity.UserEntity;
import com.haoze.service.system.UserService;
import com.haoze.utils.DateFormatUtil;
import com.haoze.utils.JsoupHttpRequest;
import com.haoze.utils.OcsCache;
import org.jsoup.Connection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

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
        Connection.Response response = JsoupHttpRequest.sendHttpRequest(url,"",null);
        assert response != null;
    }

    @Test
    public void testIo(){

        String path = System.getProperty("java.io.tmpdir");
        assert path != null;
    }

    @Test
    public void testCache() throws InterruptedException {

        OcsCache.put("test","test",5);
        //Thread.sleep(1000 * 6);

        Object test = OcsCache.get("test");
        assert test != null;
    }

    @Test
    public void testDateFormatUtil() throws ParseException {

        DateFormatUtil.parseDate("2015-05-31 12:08:25");
    }
}
