package com.epes.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeePerformanceEvaluationSystemApplicationTests {

	@Test
	public void contextLoads() {
		String key = "helleworld";
		int arraySize = 11113; // 数组大小一般取质数
		int hashCode = 0;
		for (int i = 0; i < key.length(); i++) { // 从字符串的左边开始计算
			int letterValue = key.charAt(i) - 96;// 将获取到的字符串转换成数字，比如a的码值是97，则97-96=1
			// 就代表a的值，同理b=2；
			hashCode = ((hashCode << 5) + letterValue) % arraySize;// 防止编码溢出，对每步结果都进行取模运算
		}
		System.out.println(hashCode);
	}

}
