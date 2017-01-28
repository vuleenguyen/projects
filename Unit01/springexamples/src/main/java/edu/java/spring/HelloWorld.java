package edu.java.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {
	private final static Logger LOGGER = Logger.getLogger(HelloWorld.class);

	String message;

	@Autowired(required = true)
	@Qualifier(value = "helloJavaClazz2")
	private HelloClazz helloClazz;

	public HelloWorld() {

	}

	public HelloWorld(String name, HelloClazz clazz) {
		message = "From Hello World constructor: " + name + ":"
				+ clazz.getMessage();
	}

	public void sayHello() {
		helloClazz.printMessage();
		LOGGER.info("From HelloWorld: " + message);
	}

	public String getMessage() {
		return message;
	}

	@Required
	public void setMessage(String message) {
		this.message = message;
	}

	public HelloClazz getHelloClazz() {
		return helloClazz;
	}

	public void setHelloClazz(HelloClazz helloClazz) {
		System.out.println("Inject object");
		this.helloClazz = helloClazz;
	}

}
