package edu.java.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author Do My Duyen This is Configuration Class instead of Bean Configuration
 *         file XML
 */
@Configuration
public class AppConfig {

	@Bean(name = "bean2")
	@Scope("singleton")
	public HelloClazz getHelloBean() {
		HelloClazz bean = new HelloClazz();
		bean.message = "Hello Java Class";
		return bean;
	}
}
