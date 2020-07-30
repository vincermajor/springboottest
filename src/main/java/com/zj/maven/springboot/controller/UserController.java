package com.zj.maven.springboot.controller;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zj.maven.springboot.bean.User;
@RestController
public class UserController {

	@RequestMapping("/getUser")
	@Cacheable(value="user-key")
	public User getUser() {
		User user = new User(1, "sddd", "1", new Date(), "ddd@163.com");
		System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
		return user;
	}
}
