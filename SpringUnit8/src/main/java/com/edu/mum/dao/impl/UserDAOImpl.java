package com.edu.mum.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.edu.mum.dao.UserDAO;
import com.edu.mum.dao.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private LocalSessionFactoryBean sessionFactory;

	private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

	@Override
	public void addUser(User user) {
		Session session = sessionFactory.getObject().openSession();
		try {
			session.save(user);
			session.flush();
			LOGGER.info("save " + user + " done!!!");
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list(Integer groupId) {
		Session session = sessionFactory.getObject().openSession();
		try {
			if (groupId == null) {
				Query query = session.createQuery("from User");
				return (List<User>) query.list();
			}
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("groupId", groupId));
			return new ArrayList<>(criteria.list());
		} finally {
			session.close();
		}
	}

	@Override
	public User findUser(String username) {
		Session session = sessionFactory.getObject().openSession();
		try {
		   return (User) session.get(User.class, username);
		} finally {
			session.close();
		}
	}
}
