package com.mum.java.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/jsp1/");
//		resolver.setSuffix(".js");
		// can not found forder with name is jps1 and file with suffix is js
		resolver.setPrefix("/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();		configurer.setDefinitions("/tiles/definitions.xml");
		return configurer;
	}
}
