package com.butterfly.redis.generator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.butterfly.redis.generator.service.impl.JedisIdGeneratorService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
public class TestRedis {

	/**
	 * ID生成器
	 */
	@Autowired
	private JedisIdGeneratorService jedisIdGeneratorService;

	
	/**
	 * @Description 测试生成分布式ID
	 * 
	 * @author butterfly
	 * @date 2017年8月3日 下午3:29:20 
	 * @throws Exception
	 */
	@Test
	public void testGeneratorId() throws Exception {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					while (true)
					System.out.println(jedisIdGeneratorService.generatorId("log"));
				}
			});
		}
		System.in.read();
	}
}
