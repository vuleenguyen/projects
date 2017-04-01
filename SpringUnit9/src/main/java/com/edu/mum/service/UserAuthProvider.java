package com.edu.mum.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.edu.mum.dao.UserDAO;
import com.edu.mum.dao.model.User;

@Component
public class UserAuthProvider implements AuthenticationProvider {

	@Autowired
	private UserDAO userDAO; 
	
	private static final Logger LOGGER = Logger.getLogger(UserAuthProvider.class);
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName().toString();
		User user = userDAO.findUser(username);
		if (user == null) return null;
		LOGGER.info("--------------> Found " + user + " by " + username);
		
		if (!user.getPassWord().equals(authentication.getCredentials())) return null;
		return successfull(username,authentication.getCredentials().toString(),user.getPassWord());
	}

	private UsernamePasswordAuthenticationToken successfull(String username, String credential, String passWord) {
		List<GrantedAuthority> grantedAuths = new ArrayList<>();
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new UsernamePasswordAuthenticationToken(username, passWord, grantedAuths);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
