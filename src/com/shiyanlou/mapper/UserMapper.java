package com.shiyanlou.mapper;

import java.util.List;

import com.shiyanlou.model.User;

public interface UserMapper {
	public User selectLogin(User user);
	
	public List<User> selectAllUser();
	
	public void addUser(User user);
	
	public void deleteUser(int id);
	
	public void updateUser(User user);
}
