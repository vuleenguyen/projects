package com.edu.mum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config.xml")
public class SpringUnit7Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringUnit7Application.class, args);
		ctx.start();
	}
}
