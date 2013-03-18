package net.tardivo.spring.redis.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(
				SpringConfiguration.class);
		ctx.registerShutdownHook();

		HelloService helloService = ctx.getBean(HelloService.class);

		for (int i = 0; i < 4; i++) {
			LOGGER.info(helloService.getMessage("Matheus"));
		}
	}
}
