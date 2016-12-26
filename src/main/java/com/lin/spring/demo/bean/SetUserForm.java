package com.lin.spring.demo.bean;

import java.util.HashSet;
import java.util.Set;

public class SetUserForm {

	private Set<User> users;

	public SetUserForm() {
		users = new HashSet<User>();
		users.add(new User());
		users.add(new User());
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "SetUserForm [users=" + users + "]";
	}

}
