package com.shiyanlou.service;

import java.util.List;

import com.shiyanlou.model.User;

public interface UserService {
	User login(User user);
	
	List<User> selectAllUser();
	
	void addUser(User user);
	
	void deleteUser(int id);
	
	void updateUser(User user);
	
}
