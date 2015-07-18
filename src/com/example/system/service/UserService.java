package com.example.system.service;

import java.util.List;

import org.hibernate.HibernateException;

import com.example.system.model.User;

public interface UserService {

	public boolean saveUser(User user);
	public Object queryUserById(User user);
	public List queryUserAll();
}
