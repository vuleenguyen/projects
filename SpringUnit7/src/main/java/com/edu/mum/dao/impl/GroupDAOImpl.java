package com.edu.mum.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.edu.mum.dao.GroupDAO;
import com.edu.mum.dao.model.Group;

@Repository("groupDAO")
public class GroupDAOImpl implements GroupDAO {
	
	@Autowired
	private LocalSessionFactoryBean sessionFactory;
	
	private static final Logger LOGGER = Logger.getLogger(GroupDAOImpl.class);
	
	@Override
	public void insert(Group group) {
		Session session = sessionFactory.getObject().openSession();
		try {
			session.save(group);
			session.flush();
			LOGGER.info("Save group " + group.getName() + " done!");
		} finally {
			session.close();
		}
	}

}
