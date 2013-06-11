package net.tardivo.spring.redis.cache;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);

		HelloService helloService = ctx.getBean(HelloService.class);

		log.info(helloService.getMessage("Matheus"));
		log.info(helloService.getMessage("Matheus"));
		log.info(helloService.getMessage("Matheus"));
		log.info(helloService.getMessage("Matheus"));

		log.info("{}", helloService.getHello("Matheus", "Opa"));
		log.info("{}", helloService.getHello("Matheus", "Opa"));

		log.info("{}", helloService.getAllHello(new Hello("Matheus", "Opa")));
		log.info("{}", helloService.getAllHello(new Hello("Matheus", "Opa")));
	}
}
