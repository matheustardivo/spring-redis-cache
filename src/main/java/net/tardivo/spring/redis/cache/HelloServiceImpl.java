package net.tardivo.spring.redis.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(HelloServiceImpl.class);

	@Cacheable(value = RedisCacheKey.MESSAGE)
	public String getMessage(String name) {
		LOGGER.info("Running getMessage method with the name: {}", name);
		return "Hello " + name + "...";
	}
}
