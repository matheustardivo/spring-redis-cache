package net.tardivo.spring.redis.cache;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@Slf4j
public class App {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		ctx.registerShutdownHook();

		HelloService helloService = ctx.getBean(HelloService.class);

		for (int i = 0; i < 10; i++) {
			log.info(helloService.getMessage("Matheus"));

			log.info("{}", helloService.getHello("Matheus", "Opa"));

			log.info("{}", helloService.getAllHello(new Hello("Matheus", "Opa")));
		}
	}
}
