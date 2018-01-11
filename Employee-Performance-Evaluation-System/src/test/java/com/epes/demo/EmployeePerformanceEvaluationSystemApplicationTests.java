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
	public void contextLoads(){
		IdService idService = new IdService();
		System.out.println(idService.getIDToHexString());
		System.out.println(idService.getCode("POR"));
	}


	/**
	 *
	 */
	@Test
	public void insertUserTest(){
		Map<String ,Object> map = new HashMap<>();
		Suser susers = new Suser();
		susers.setName("泽轩");
		susers.setCode("MS001");
		susers.setRole(1);
		susers.setAdd("重庆沙坪坝");
		susers.setAge(21);
		System.out.println(map.get("message"));

	}
}
