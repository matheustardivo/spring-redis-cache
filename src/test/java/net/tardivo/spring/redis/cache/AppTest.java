package net.tardivo.spring.redis.cache;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@Slf4j
public class AppTest {

	@Test
	public void run() {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ctx.registerShutdownHook();

		HelloService helloService = ctx.getBean(HelloService.class);

		ByeService byeService = ctx.getBean(ByeService.class);

		for (int i = 0; i < 100; i++) {
			log.info(helloService.getMessage("Matheus" + i));

			log.info("{}", helloService.getByeByName("Matheus" + i));

			log.info("{}", helloService.getHello("Matheus" + i, "Opa"));

			log.info("{}", helloService.getAllHello(new Hello("Matheus" + i, "Opa")));

			log.info("{}", byeService.getBye("Rodrigo" + i, 10));

			log.info("{}", byeService.getAllBye(new Bye("Rodrigo" + i, 10)));

			log.info("{}", helloService.sayGoodBye("Rodrigo" + i, 10));
		}
	}
}
