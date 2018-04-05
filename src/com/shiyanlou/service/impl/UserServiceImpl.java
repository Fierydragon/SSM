package com.shiyanlou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shiyanlou.mapper.UserMapper;
import com.shiyanlou.model.User;
import com.shiyanlou.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectLogin(user);
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userMapper.selectAllUser();
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.addUser(user);
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(id);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

}
