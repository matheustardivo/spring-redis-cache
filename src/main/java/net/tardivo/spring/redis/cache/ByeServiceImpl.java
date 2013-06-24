package net.tardivo.spring.redis.cache;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ByeServiceImpl implements ByeService {

	@Cacheable(value = "ByeService~getBye")
	@CacheConfig(ttl = 60)
	public Bye getBye(String name, long times) {
		log.info("Running getBye with name: {}, times: {}", name, times);
		return new Bye(name, times);
	}

	@Cacheable(value = "ByeService~getAllBye")
	@CacheConfig(ttl = 60)
	public List<Bye> getAllBye(Bye bye) {
		log.info("Running getAllBye with bye: {}", bye);

		List<Bye> byeList = new ArrayList<Bye>();
		for (int i = 0; i < 10; i++) {
			byeList.add(new Bye(bye.getMessage(), bye.getTimes()));
		}

		return byeList;
	}
}
