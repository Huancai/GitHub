package com.spring.dao;

import com.spring.model.User;

public interface IUserDao {

	public void add(User user);
	public void del(int id);
	public User load(int id);
	public void update(int id,User user);
}
