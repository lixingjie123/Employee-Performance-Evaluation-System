package com.epes.demo;

import com.epes.demo.entity.Suser;
import com.epes.demo.service.IdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeePerformanceEvaluationSystemApplicationTests {

	@Test
	public void contextLoads() throws NoSuchFieldException, IllegalAccessException {
		IdService idService = new IdService();
		System.out.println(idService.getIDToHexString());
		for (int i = 0; i<10; i++) {
			System.out.println(idService.getCode(Suser.class));
		}
		System.out.println(idService.getCode("UR"));
	}


	/**
	 *
	 */
	@Test
	public void insertUserTest(){
		Map<String ,Object> map = new HashMap<>();
		Suser susers = new Suser();
		susers.setUname("泽轩");
		susers.setCodes("MS001");
		susers.setRole(1);
		susers.setAddss("重庆沙坪坝");
		susers.setAge(21);
		System.out.println(map.get("message"));

	}
}
