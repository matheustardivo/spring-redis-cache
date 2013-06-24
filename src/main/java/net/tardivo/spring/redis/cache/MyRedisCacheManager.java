package net.tardivo.spring.redis.cache;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

@Slf4j
public class MyRedisCacheManager extends RedisCacheManager {

	public MyRedisCacheManager(@SuppressWarnings("rawtypes") RedisTemplate template) {
		super(template);
	}

	@Override
	public Cache getCache(String name) {
		log.debug("MyRedisCacheManager {}", name);
		return super.getCache(name);
	}
}
