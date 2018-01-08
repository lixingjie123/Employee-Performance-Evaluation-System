package com.epes.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.epes.demo.dao")
public class EmployeePerformanceEvaluationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePerformanceEvaluationSystemApplication.class, args);
	}
}
