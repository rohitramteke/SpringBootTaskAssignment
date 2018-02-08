package com.task.assignment.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.task.assignment.springboot.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.task.assignment.springboot"})
// @Configuration @EnableAutoConfiguration @ComponentScan can be used instead of @SpringBootApplication
public class SpringBootTaskAssignmentApp{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTaskAssignmentApp.class, args);
	}
}
