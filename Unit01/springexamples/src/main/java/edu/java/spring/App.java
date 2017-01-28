package edu.java.spring;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		HelloClazz obj = (HelloClazz)context.getBean("helloJavaClazz");
//		obj.printMessage();
		
		// This case is used for singleton scope it has only one instance so
		// obj2 == obj1 ===> result is true
//		HelloClazz obj2 = (HelloClazz)context.getBean("helloJavaClazz");
//		obj2.printMessage();
//		System.out.println(obj2 == obj);
		
//		ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("beans.xml");
//		context2.registerShutdownHook();
		
		ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("beans.xml");
		context2.start();
//		HelloWorld helloWorld = (HelloWorld) context2.getBean("helloWorld");
//		helloWorld.sayHello();
//		JavaClazz clazz = (JavaClazz) context2.getBean("jee01");
//		System.out.println("Map Implement is " + clazz.getStudents());
//		System.out.println("There are "+ clazz.getStudents().size() + " in the class");
//	
//		HelloClazz helloClazz = (HelloClazz) context2.getBean("helloJavaClazz");
//		System.out.println("Total classes is " + helloClazz.getClazzes().size());
//		System.out.println("There are " + helloClazz.getClazzes().get(0).getStudents().size());
//		System.out.println("There are second clazzes " + helloClazz.getClazzes().get(1));
	
		HelloWorld helloWorld = (HelloWorld) context2.getBean("helloWorld");
		helloWorld.sayHello();
		
		context2.stop();
	}	
}
