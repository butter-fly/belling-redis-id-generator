package com.butterfly.redis.generator.service;

/**  
 * @Description	分布式ID生成接口
 * @author		butterfly
 * @date	    2017年8月3日 下午2:30:32  
 */

public interface IdGeneratorService {
	
	/**
	 * @Description 生成分布式ID
	 * 
	 * @author butterfly
	 * @return
	 */
	Long generatorId(String biz);
}
