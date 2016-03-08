package com.spring.service;

import com.spring.dao.IUserDao;
import com.spring.model.User;

public class UserService implements IUserService {

	private IUserDao userDao;
	
	
	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
	}

	@Override
	public void del(int id) {
		userDao.del(id);
	}

	@Override
	public User load(int id) {
		return userDao.load(id);
	}

	@Override
	public void update(int id, User user) {
		userDao.update(id, user);
	}

}
