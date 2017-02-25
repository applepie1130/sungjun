package com.sungjun.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configurable
@ComponentScan(basePackages = "com.sungjun")
public class RedisConfigure {
	
//	@Bean
//	public JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//		jedisConnectionFactory.setHostName("127.0.0.1");
//		jedisConnectionFactory.setPort(6379);
//		jedisConnectionFactory.setTimeout(0);
//		jedisConnectionFactory.setUsePool(true);
//	  
//		return jedisConnectionFactory;
//	 }
//	
//	
//	 @Bean
//	 public StringRedisTemplate redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
//		 StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//		 stringRedisTemplate.setConnectionFactory(jedisConnectionFactory);
//		 return stringRedisTemplate;
//	 }
//
//	 
//	 @Bean
//	 public JedisCluster jedisCluster() {
//		 HostAndPort hostAndPort = new HostAndPort("127.0.0.1", 6379);
//		 JedisCluster jedisCluster = new JedisCluster(hostAndPort);
//		 return jedisCluster;
//	}
}
