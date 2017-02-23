package com.mum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class AppSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("VuLe").password("123456")
				.roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
								.antMatchers("/user/**").hasRole("USER")
								.anyRequest().authenticated()
								.and()
			.formLogin()
								.loginPage("/login")
								.permitAll()
								.usernameParameter("j_username")
								.passwordParameter("j_password")
								.loginProcessingUrl("/login")
								.failureUrl("/login?error")
								.defaultSuccessUrl("/user");
	}

}
