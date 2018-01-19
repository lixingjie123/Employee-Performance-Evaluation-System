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

}
