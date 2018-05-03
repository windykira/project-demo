package com.haoze;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDemoApplicationTests {

	@Test
	public void contextLoads() {

		String str = "36.2℃P98次/分R20次/分BP96/66mmHg";
		String newStr = Pattern.compile("[^0-9./℃]").matcher(str).replaceAll("")
				.replace("℃",",").replace("/",",");
		assert newStr != null;
	}

}
