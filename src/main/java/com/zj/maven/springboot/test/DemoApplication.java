package com.zj.maven.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
//@SpringBootApplication	//同一项目只能有一个 SpringBootApplication注释
public class DemoApplication {

	@RequestMapping("/test")
	String home() {
		return "hello spring boot";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
