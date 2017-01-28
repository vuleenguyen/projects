package edu.java.spring;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;

public class HelloClazz implements DisposableBean {
	String message;

	private List<JavaClazz> clazzes;

	public HelloClazz() {
		message = "From Constructor: Say hello everyone!";
	}

	public HelloClazz(int person) {
		message = "From Constructor: Say hello to " + person + " person(s)!";
	}

	public HelloClazz(HelloClazz clazz) {
		message = clazz.message;
	}

	public void setMessage(String message) {
		this.message = "Call From Setter: " + message;
	}

	public void printMessage() {
		System.out.println("Your Message: " + message);
	}

	public void initMessage() {
		System.out.println("Calling init method...");
		message = "From init method: Say hello bean!";
	}

	@Override
	public void destroy() throws Exception {
		message = null;
		System.out.println("Message is null");
	}

	public String getMessage() {
		return message;
	}

	public List<JavaClazz> getClazzes() {
		return clazzes;
	}

	public void setClazzes(List<JavaClazz> clazzes) {
		this.clazzes = clazzes;
	}

}
