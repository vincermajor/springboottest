package com.zj.maven.springboot.config;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				// TODO Auto-generated method stub
				StringBuilder sBuilder = new StringBuilder();
				sBuilder.append(target.getClass().getName());
				sBuilder.append(method.getName());
				for (Object object : params) {
					sBuilder.append(object.toString());
				}
				return sBuilder.toString();
			}
		};
	}
}
