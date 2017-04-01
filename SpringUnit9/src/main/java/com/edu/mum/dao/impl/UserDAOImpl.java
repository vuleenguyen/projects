package com.edu.mum.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.edu.mum.dao.UserDAO;
import com.edu.mum.dao.model.Group;
import com.edu.mum.dao.model.User;

import businesslogic.UserFactory;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	public static final Integer SIZE_OF_PAGE = 2;
	
	@Autowired
	private LocalSessionFactoryBean sessionFactory;

	private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	
	@Override
	public void addBatch(List<Group> groups) {
		Transaction tx = null;
		Session session = null;
		try {
			session = sessionFactory.getObject().openSession();
			tx = session.beginTransaction();
			Group group1 = groups.get(0);
			Group group2 = groups.get(1);
			for(int i=1 ; i <= 10 ; i++) {
				if (i % 2 == 1) {
					session.save(UserFactory.generate(i, group1));
				} else {
					session.save(UserFactory.generate(i, group2));
				}
			}
			session.flush();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUserByNativeSQL() {
		// Write by Native SQL
		String sql = "select * from IOWA_USER";
		Session session = sessionFactory.getObject().openSession();
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(User.class);
		return (List<User>)query.list();
	}

	@Override
	public void addUser(User user) throws Exception {
		Session session = sessionFactory.getObject().openSession();
		try {
			validateUser(user);
			session.save(user);
			session.flush();
			LOGGER.info("save " + user + " done!!!");
		} finally {
			session.close();
		}
	}

	private void validateUser(User user) throws Exception {
		if (findUser(user.getUserName()) != null) {
			throw new Exception("This username existed in system");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list(Integer groupId, Integer age, Integer page) {
 		Session session = sessionFactory.getObject().openSession();
		try {
			if (groupId == null && age == null && page == null) {
				Query query = session.createQuery("from User order by age desc");
				return (List<User>) query.list();
			}
			Criteria criteria = session.createCriteria(User.class);
			if (groupId != null) {
				criteria.add(Restrictions.eq("group.id", groupId));
			}
			if (age != null) {
			    criteria.add(Restrictions.gt("age", age));
			}
			criteria.addOrder(Order.desc("age"));
			
			if (page != null) {
				int start = (page - 1) * SIZE_OF_PAGE;
				criteria.setFirstResult(start);
				criteria.setMaxResults(SIZE_OF_PAGE);
			}
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

	@Override
	public void delete(User user) {
		// Way 1
		Session session = sessionFactory.getObject().openSession();
		try {
			session.delete(user);
			session.flush();
			LOGGER.info("Delete user with " + user.getUserName() + " done!!!");
		} finally {
			session.close();
		}
		
		// Way 2
//		Query query = session.createQuery("delete from User where userName like :userName");
//		query.setParameter("userName", userName);
//		int result = query.executeUpdate();
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.getObject().openSession();
		try {
			session.update(user);
			session.flush();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUser(int groupId) {
		Session session = sessionFactory.getObject().openSession();
		try {
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("group.id", groupId));
			return (List<User>) criteria.list();
		} finally {
			session.close();
		}
	}

	@Override
	public Integer averageAge() {
		Session session = sessionFactory.getObject().openSession();
		try {
			Criteria criteria = session.createCriteria(User.class);
			criteria.setProjection(Projections.avg("age"));
			Double average = (Double) criteria.list().get(0);
			return average.intValue();
		} finally {
			session.close();
		}
	}

	@Override
	public User findUserByEmail(String email) {
		Session session = sessionFactory.getObject().openSession();
		try {
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("email", email));
			if (criteria.list().size() == 0) {
				return null;
			}
			return (User)criteria.list().get(0);
		} finally {
			session.close();
		}
	}

}
