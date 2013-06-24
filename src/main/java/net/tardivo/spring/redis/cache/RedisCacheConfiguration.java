package net.tardivo.spring.redis.cache;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;

@Slf4j
public class RedisCacheConfiguration {

	public static void configureTtlWithReflection(RedisCacheManager redisCacheManager) {
		Map<String, Long> map = new HashMap<String, Long>();

		@SuppressWarnings("unchecked")
		List<Class<? extends Object>> classesWithCache = Arrays.asList(ByeServiceImpl.class, HelloServiceImpl.class);

		for (Class<? extends Object> clazz : classesWithCache) {
			log.debug("Scanning class {} for Cacheable and CacheConfig annotations", clazz);

			Method[] classMethods = clazz.getMethods();

			for (Method method : classMethods) {
				log.debug("Inspect method {}", method);

				String cacheName = null;
				Cacheable cacheable = method.getAnnotation(Cacheable.class);
				if (cacheable != null) {
					cacheName = cacheable.value()[0];
					log.debug("Cacheable annotation name: {}", cacheName);
				}

				long ttl = 60;
				CacheConfig cacheConfig = method.getAnnotation(CacheConfig.class);
				if (cacheConfig != null) {
					ttl = cacheConfig.ttl();
					log.debug("CacheConfig annotation ttl: {}", ttl);
				}

				if (StringUtils.isNotBlank(cacheName)) {
					map.put(cacheName, ttl);
				}
			}
		}

		redisCacheManager.setExpires(map);
	}
}
