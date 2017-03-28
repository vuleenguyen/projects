package com.edu.mum.dao.model;

public class User {

	private String userName;
	private String passWord;
	private String email;
	private Integer age;
	private int groupId;
	private String groupToInput;
	
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

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public void setGroupToInput(String groupToInput) {
		this.groupToInput = groupToInput;
	}

	public String getGroupToInput() {
		return groupToInput;
	}
	
}
