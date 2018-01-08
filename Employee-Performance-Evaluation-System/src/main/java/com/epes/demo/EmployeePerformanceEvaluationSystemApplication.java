package com.epes.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */

@SpringBootApplication
@MapperScan("com.epes.demo.dao")
public class EmployeePerformanceEvaluationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePerformanceEvaluationSystemApplication.class, args);
	}
}
