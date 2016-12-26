package com.lin.spring.demo.bean;

import java.util.Map;

public class MapUserForm {
	private Map<String, User> users;

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "MapUserForm [users=" + users + "]";
	}

}
