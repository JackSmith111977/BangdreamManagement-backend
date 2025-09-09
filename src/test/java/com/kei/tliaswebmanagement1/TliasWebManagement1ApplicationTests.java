package com.kei.tliaswebmanagement1;

import cn.hutool.core.io.FileUtil;
import com.google.gson.Gson;
import com.kei.tliaswebmanagement1.pojo.Result;
import com.kei.tliaswebmanagement1.utils.AliyunOSSOperator;
import com.kei.tliaswebmanagement1.utils.AliyunOSSProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.io.File;

@SpringBootTest
class TliasWebManagement1ApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
	@Autowired
	private Gson gson;

	@Test
	void testJson(){
		System.out.println(gson.toJson(Result.success("Hello Gson")));
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testScope(){
		for(int i = 0; i < 10; i++){
			Object object = applicationContext.getBean("deptController");
			System.out.println(object);

		}
	}

	@Test
	public void testUpload() throws Exception {
		File file = new File("F:\\图片\\a6000\\DSC00355.JPG");
		String url = aliyunOSSOperator.upload(FileUtil.readBytes(file),file.getName());
		System.out.println(url);

	}

}
