package net.tardivo.spring.redis.cache;

import java.util.List;

public interface HelloService {

	public String getMessage(String name);

	public Bye getByeByName(String name);

	public Hello getHello(String name, String message);

	public List<Hello> getAllHello(Hello hello);

	public Bye sayGoodBye(String message, long times);
}
