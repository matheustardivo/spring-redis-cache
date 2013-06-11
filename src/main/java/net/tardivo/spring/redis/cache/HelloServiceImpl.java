package net.tardivo.spring.redis.cache;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

	@Cacheable(value = RedisCacheKey.MESSAGE)
	public String getMessage(String name) {
		log.info("Running getMessage method with the name: {}", name);
		return "Hello " + name + "...";
	}

	@Cacheable(value = RedisCacheKey.HELLO)
	public Hello getHello(String name, String message) {
		log.info("Running getHello method with the name: {}, message: {}", name, message);
		Hello hello = new Hello(name, message);
		hello.setRelated(new HelloRelated("Otheeeeeer"));
		return hello;
	}

	@Cacheable(value = RedisCacheKey.HELLO_LIST)
	@Override
	public List<Hello> getAllHello(Hello hello) {
		log.info("Running getAllHello method with the hello: {}", hello);

		List<Hello> helloList = new ArrayList<Hello>();
		for (int i = 0; i < 10; i++) {
			Hello hello2 = new Hello(hello.getName(), hello.getMessage());
			hello2.setRelated(new HelloRelated("Otheeeeeer"));
			helloList.add(hello2);
		}
		return helloList;
	}
}
