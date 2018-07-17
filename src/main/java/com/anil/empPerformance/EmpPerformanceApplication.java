package com.anil.empPerformance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:application-context.xml"})
public class EmpPerformanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpPerformanceApplication.class, args);
	}
}
