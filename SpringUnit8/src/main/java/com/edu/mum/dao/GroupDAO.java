package com.edu.mum.dao;

import java.util.List;

import com.edu.mum.dao.model.Group;

public interface GroupDAO {
	public void insert(Group group);	
	public List<Group> list(String pattern);
	public void delete(int id);
	public void update(Group group);
	public Group find(int id);
	public int find(String groupInput);
}
