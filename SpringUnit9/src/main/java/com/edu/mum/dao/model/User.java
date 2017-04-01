package com.edu.mum.dao.model;

import org.apache.log4j.Logger;

public class User implements Comparable<User> {

	private String userName;
	private String passWord;
	private String email;
	private Integer age;
	private Group group;
	private String groupToInput;
	private boolean update;
	
	private static final Logger LOGGER = Logger.getLogger(User.class);
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setGroupToInput(String groupToInput) {
		this.groupToInput = groupToInput;
	}

	public String getGroupToInput() {
		return groupToInput;
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	@Override
	public int compareTo(User user) {
		if (this.age == null && user.age == null) {
			return 0;
		}
		return Math.subtractExact(this.age, user.age);
	}

}
