package net.tardivo.spring.redis.cache;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

	@Cacheable(value = "HelloService~getMessage", key = "T(net.tardivo.spring.redis.cache.CacheKeySupport).generateKey('HelloService~getMessage', #name)")
	@CacheConfig(ttl = 60)
	public String getMessage(String name) {
		log.info("Running getMessage method with the name: {}", name);
		return "Hello " + name + "...";
	}

	@Cacheable(value = "HelloService~getHello", key = "T(net.tardivo.spring.redis.cache.CacheKeySupport).generateKey('HelloService~getHello', #name, #message)")
	@CacheConfig(ttl = 60)
	public Hello getHello(String name, String message) {
		log.info("Running getHello method with the name: {}, message: {}", name, message);
		Hello hello = new Hello(name, message);
		hello.setRelated(new HelloRelated("Otheeeeeer"));
		return hello;
	}

	@Cacheable(value = "HelloService~getAllHello")
	@CacheConfig(ttl = 60)
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

	@Cacheable(value = "HelloService~sayGoodBye")
	@CacheConfig(ttl = 60)
	public Bye sayGoodBye(String message, long times) {
		log.info("Running sayGoodBye method with the message: {}, times: {}", message, times);
		return new Bye(message, times);
	}

	@Cacheable(value = "HelloService~getByeByName", key = "T(net.tardivo.spring.redis.cache.CacheKeySupport).generateKey('HelloService~getByeByName', #name)")
	@CacheConfig(ttl = 60)
	public Bye getByeByName(String name) {
		log.info("Running getByeByName method with the name: {}", name);
		return new Bye(name, 10);
	}
}
