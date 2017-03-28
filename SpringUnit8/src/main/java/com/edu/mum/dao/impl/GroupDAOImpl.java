package com.edu.mum.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Group> list(String pattern) {
		Session session = sessionFactory.getObject().openSession();
		Query query;
		try {
			if (StringUtils.isBlank(pattern)) {
				query = session.createQuery("from Group");
				return (List<Group>) query.list();
			} 
			Criteria criteria = session.createCriteria(Group.class);
			criteria.add(Expression.like("name", "%" + pattern + "%", MatchMode.ANYWHERE).ignoreCase());
			return (List<Group>) criteria.list();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getObject().openSession();
		Object object = session.get(Group.class, id);
		if (object == null)
			return;
		try {
			Group group = (Group) object;
			session.delete(group);
			session.flush();
			LOGGER.info("Delete group " + group.getName() + " successful");
		} catch (Exception e) {
			throw new RuntimeException("Error when delete Group with GroupId: " + id);
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Group group) {
		Session session = sessionFactory.getObject().openSession();
		try {
			Object object = session.merge(group);
			if (object == null)
				return;
			Group groupToUpdate = (Group) object;
			session.update(groupToUpdate);
			session.flush();
		} catch (Exception e) {
			LOGGER.info("Update group " + group.getName() + " successful!");
		} finally {
			session.close();
		}
	}

	@Override
	public Group find(int id) {
		Session session = sessionFactory.getObject().openSession();
		return (Group) session.get(Group.class, id);
	}

	@Override
	public int find(String groupInput) {
		Session session = sessionFactory.getObject().openSession();
		Criteria criteria = session.createCriteria(Group.class);
		criteria.add(Restrictions.eq("name", groupInput));
		if (criteria.list() == null) {
			return -1;
		}
		return ((Group)criteria.list().get(0)).getId();
	}

}
