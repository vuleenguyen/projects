package com.edu.mum.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.social.security.SocialAuthenticationServiceRegistry;
import org.springframework.social.security.provider.SocialAuthenticationService;

public class JazzSocialAuthServiceRegistry extends SocialAuthenticationServiceRegistry {
	
	private List<SocialAuthenticationService<?>> authenticationService;
	
	public JazzSocialAuthServiceRegistry(List<SocialAuthenticationService<?>> authenticationService) {
		this.authenticationService = authenticationService;
	}

	public List<SocialAuthenticationService<?>> getAuthenticationService() {
		return authenticationService;
	}
	
	@PostConstruct
	public void init() {
		if (authenticationService == null) return;
		authenticationService.forEach(auth -> super.addAuthenticationService(auth));
	}
	
}
