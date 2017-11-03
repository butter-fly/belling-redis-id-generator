package com.butterfly.redis.generator.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description Jedis配置装载
 * @author butterfly
 * @date 2017年8月3日 下午1:51:16
 */
@ConfigurationProperties(prefix = JedisProperties.JEDIS_PREFIX) 
public class JedisProperties {
	
	/**
	 * 配置前缀
	 */
	public static final String JEDIS_PREFIX = "jedis";  
	
	/**
	 * 超时时间
	 */
	private int timeout;
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 主机地址
	 */
	private String host;
	
	/**
	 * 端口号
	 */
	private int port = 6379;

	/**
	 * 最大活动
	 */
	private int maxActive;
	/**
	 * 最大等待时间
	 */
	private int maxWait;
	/**
	 * 最大连接
	 */
	private int maxTotal;
	
	/**
	 * 
	 */
	private int maxIdle;
	
	/**
	 * 是否验证
	 */
	private boolean testOnBorrow;

	/**
	 * @return the {@link #timeout}
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout the {@link #timeout} to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * @return the {@link #password}
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the {@link #password} to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the {@link #host}
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the {@link #host} to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the {@link #port}
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the {@link #port} to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the {@link #maxActive}
	 */
	public int getMaxActive() {
		return maxActive;
	}

	/**
	 * @param maxActive the {@link #maxActive} to set
	 */
	public void setMaxActive(int maxActive) {
		this.maxActive = maxActive;
	}

	/**
	 * @return the {@link #maxWait}
	 */
	public int getMaxWait() {
		return maxWait;
	}

	/**
	 * @param maxWait the {@link #maxWait} to set
	 */
	public void setMaxWait(int maxWait) {
		this.maxWait = maxWait;
	}

	/**
	 * @return the {@link #maxTotal}
	 */
	public int getMaxTotal() {
		return maxTotal;
	}

	/**
	 * @param maxTotal the {@link #maxTotal} to set
	 */
	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	/**
	 * @return the {@link #maxIdle}
	 */
	public int getMaxIdle() {
		return maxIdle;
	}

	/**
	 * @param maxIdle the {@link #maxIdle} to set
	 */
	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	/**
	 * @return the {@link #testOnBorrow}
	 */
	public boolean getTestOnBorrow() {
		return testOnBorrow;
	}

	/**
	 * @param testOnBorrow the {@link #testOnBorrow} to set
	 */
	public void setTestOnBorrow(boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
}
