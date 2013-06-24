package net.tardivo.spring.redis.cache;

import java.util.List;

public interface ByeService {

	public Bye getBye(String name, long times);

	public List<Bye> getAllBye(Bye bye);
}
