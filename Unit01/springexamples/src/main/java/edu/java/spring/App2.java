package edu.java.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		HelloClazz helloClazz = (HelloClazz) ctx.getBean("bean2");
		helloClazz.printMessage();
		
		// return true because @Scope Singleton
		HelloClazz helloClazz2 = (HelloClazz) ctx.getBean("bean2");
		System.out.println(helloClazz == helloClazz2);
	}
}
