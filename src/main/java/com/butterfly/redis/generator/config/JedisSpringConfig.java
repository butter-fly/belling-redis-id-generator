package com.butterfly.redis.generator.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.butterfly.redis.generator.client.JedisClient;
import com.butterfly.redis.generator.properties.JedisProperties;
import com.google.common.base.Strings;

/**
 * @Description
 * @author butterfly
 * @date 2017年8月3日 下午1:51:16
 */
@Configuration  
@PropertySource(value = "classpath:jedis.properties")
@EnableConfigurationProperties(JedisProperties.class)// 开启属性注入,通过@autowired注入   
@ConditionalOnClass(JedisClient.class) // 判断这个类是否在classpath中存在  
public class JedisSpringConfig {
	
	/**
	 * 属性配置对象
	 */
	@Autowired
	private JedisProperties prop;

	
	/**
	 * @Description 
	 * 
	 * @author butterfly
	 * @return
	 */
	@Bean(name = "jedisPool")
	public JedisPool jedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(prop.getMaxTotal());
		config.setMaxIdle(prop.getMaxIdle());
		config.setMaxWaitMillis(prop.getMaxWait());
		config.setTestOnBorrow(prop.getTestOnBorrow());
		JedisPool jedisPool = null;
		if (!Strings.isNullOrEmpty(prop.getPassword())) {
			jedisPool = new JedisPool(config, prop.getHost(), prop.getPort(), prop.getTimeout(), prop.getPassword());
		} else {
			jedisPool = new JedisPool(config, prop.getHost(), prop.getPort(), prop.getTimeout());
		}
		return jedisPool;
	}

	
	/**
	 * @Description 
	 * 
	 * @author butterfly
	 * @param pool
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(JedisClient.class) // 容器中如果没有RedisClient这个类,那么自动配置这个RedisClient
	public JedisClient redisClient(@Qualifier("jedisPool") JedisPool pool) {
		JedisClient jedisClient = new JedisClient();
		jedisClient.setJedisPool(pool);
		return jedisClient;
	}
}
