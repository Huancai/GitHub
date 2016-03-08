package com.spring.action;

import com.spring.model.User;
import com.spring.service.IUserService;

public class UserAction {

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IUserService getService() {
		return service;
	}

	public void setService(IUserService service) {
		this.service = service;
	}

	private User user;
	private int id;
	IUserService service;

	public void add() {
		service.add(user);
	}

	public void del() {
		service.del(id);
	}

	public User load() {
		return service.load(id);
	}

	public void update() {
		service.update(id, user);
	}
}
