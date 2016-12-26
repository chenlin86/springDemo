package com.lin.spring.demo.bean;

import java.util.List;

public class ListUserForm {

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "ListUserForm [users=" + users + "]";
	}

}
