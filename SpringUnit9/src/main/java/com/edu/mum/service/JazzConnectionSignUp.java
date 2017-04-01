package com.edu.mum.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import com.edu.mum.dao.GroupDAO;
import com.edu.mum.dao.UserDAO;
import com.edu.mum.dao.model.User;

public class JazzConnectionSignUp implements ConnectionSignUp {

	private static final Logger LOGGER = Logger.getLogger(JazzConnectionSignUp.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private GroupDAO groupDAO;	
	@Override
	public String execute(final Connection<?> connection) {
		UserProfile userProfile = connection.fetchUserProfile();
		LOGGER.info("-=------ > id " +userProfile.getId() + " name: " + userProfile.getName());
		User user = userDAO.findUserByEmail(userProfile.getEmail());
		if (user != null) return user.getUserName();
		
		user = new User();
		user.setUserName(userProfile.getEmail());
		user.setPassWord("123");
		user.setGroup(groupDAO.list(null).size() == 0 ? null : groupDAO.list(null).get(0));
		user.setEmail(userProfile.getEmail());
		try {
			userDAO.addUser(user);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), new RuntimeException(e.getMessage()));
		}
		return user.getUserName();
	}

}
