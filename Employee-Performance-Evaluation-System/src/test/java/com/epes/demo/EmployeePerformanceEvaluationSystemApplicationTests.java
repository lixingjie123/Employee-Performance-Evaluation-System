package com.epes.demo;

import com.epes.demo.entity.Susers;
import com.epes.demo.service.IdService;
import com.epes.demo.tool.Encryption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeePerformanceEvaluationSystemApplicationTests {

	@Test
	public void contextLoads(){
		IdService idService = new IdService();
		System.out.println(idService.getIDToHexString());
		System.out.println(idService.getCode("POR"));
	}

	/**
	 * 密码加密测试
	 */
	@Test
	public void testEncryptionByMd5() {
		String password = "Li(2qqx)";
		String password2 = "Li(2qqx)";
		try {
			password = Encryption.EncoderByMd5(password);
			password2 = Encryption.EncoderByMd5(password2);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(password);
		System.out.println(password2);
		if (password.equals(password2)) {
			System.out.println("完全相等");
		}
	}

	/**
	 * 密码加密测试
	 */
	@Test
	public void testEncryptionBySha1(){
		String password = "Li(2qqx)";
		String password2 = "Li(2qqx)";
		try {
			password = Encryption.EncoderBySha1(password);
			password2 = Encryption.EncoderBySha1(password2);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		System.out.println(password);
		System.out.println(password2);
		if (password.equals(password2)){
			System.out.println("完全一样");
		}
	}

	/**
	 *
	 */
	@Test
	public void insertUserTest(){
		Map<String ,Object> map = new HashMap<>();
		Susers susers = new Susers();
		susers.setName("泽轩");
		susers.setCode("MS001");
		susers.setRole(1);
		susers.setAdd("重庆沙坪坝");
		susers.setAge(21);
		System.out.println(map.get("message"));

	}
}
