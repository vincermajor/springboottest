package com.zj.maven.springboot.test;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.zj.maven.springboot.bean.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	public void test() throws Exception {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		System.out.println("aaaaa = " + stringRedisTemplate.opsForValue().get("aaa"));
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}
	
	@Test
	public void testObj() throws Exception {
		User user = new User(null, "xxxx", "1", new Date(), "15161@163.com");
		ValueOperations<String, User> operations = redisTemplate.opsForValue();
		operations.set("com.neox", user);
		operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
		Thread.sleep(1000);
		
		boolean exists = redisTemplate.hasKey("com.neo.f");
		if (exists) {
			System.out.println("exists is ture");
		} else {
			System.out.println("exists is false");
		}
		
	}
	
}
