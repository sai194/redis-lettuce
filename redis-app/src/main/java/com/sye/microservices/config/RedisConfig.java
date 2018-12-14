package com.sye.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
/*
 * @ComponentScan("com.sye.microservices")
 * 
 * @EnableRedisRepositories(basePackages = "com.sye.microservices.repository")
 */
public class RedisConfig {
	@Bean
	LettuceConnectionFactory lettuceConnectionFactory() {

		return new LettuceConnectionFactory();

	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(lettuceConnectionFactory());
		return template;
	}

}
