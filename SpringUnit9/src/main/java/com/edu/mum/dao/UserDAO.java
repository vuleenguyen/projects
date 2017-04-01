package com.edu.mum.dao;

import java.util.List;

import com.edu.mum.dao.model.Group;
import com.edu.mum.dao.model.User;

public interface UserDAO {
	
	public void addUser(User user) throws Exception;

	public List<User> list(Integer groupId, Integer age, Integer page);

	public User findUser(String username);

	public void delete(User user);

	public void update(User user);

	public List<User> findUser(int groupId);

	public Integer averageAge();
	
	public List<User> listUserByNativeSQL();

	public void addBatch(List<Group> groups);
	
	public User findUserByEmail(String email);
	
}
