package com.spring.service;

import com.spring.model.User;

public interface IUserService {
	public void add(User user);

	public void del(int id);

	public User load(int id);

	public void update(int id, User user);
}
