package com.spring.dao;

import com.spring.model.User;

public class UserDao implements IUserDao {

	@Override
	public void add(User user) {
		System.err.println("UserDao add");
	}

	@Override
	public void del(int id) {
		System.err.println("UserDao del");
	}

	@Override
	public User load(int id) {
		System.err.println("UserDao load");
		return null;
	}

	@Override
	public void update(int id, User user) {
		System.err.println("UserDao update");
	}

}
