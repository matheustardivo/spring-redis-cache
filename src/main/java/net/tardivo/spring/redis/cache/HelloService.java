package net.tardivo.spring.redis.cache;

import java.util.List;

public interface HelloService {

	public String getMessage(String name);

	public Hello getHello(String name, String message);

	public List<Hello> getAllHello(Hello hello);
}
