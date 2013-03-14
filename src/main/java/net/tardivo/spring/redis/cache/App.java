package net.tardivo.spring.redis.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				SpringConfiguration.class);

		HelloService helloService = ctx.getBean(HelloService.class);

		LOGGER.info(helloService.getMessage("Matheus"));
		LOGGER.info(helloService.getMessage("Matheus"));
		LOGGER.info(helloService.getMessage("Matheus"));
		LOGGER.info(helloService.getMessage("Matheus"));
	}
}
