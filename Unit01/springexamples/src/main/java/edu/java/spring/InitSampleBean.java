package edu.java.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitSampleBean implements BeanPostProcessor {

//	@Override
//	public HelloClazz postProcessAfterInitialization(Object bean, String arg1)
//			throws BeansException {
//		System.out.println("After initialization: " +bean.getClass().getName().toString());
//		return (HelloClazz) bean;
//	}
//
//	@Override
//	public HelloClazz postProcessBeforeInitialization(Object bean, String arg1)
//			throws BeansException {
//		System.out.println("Before initialization: " +bean.getClass().getName().toString());
//		return (HelloClazz) bean;
//	}
	
	@Override
	public HelloWorld postProcessAfterInitialization(Object bean, String arg1)
			throws BeansException {
		System.out.println("After initialization: " +bean.getClass().getName().toString());
		return (HelloWorld) bean;
	}

	@Override
	public HelloWorld postProcessBeforeInitialization(Object bean, String arg1)
			throws BeansException {
		System.out.println("Before initialization: " +bean.getClass().getName().toString());
		return (HelloWorld) bean;
	}

}
