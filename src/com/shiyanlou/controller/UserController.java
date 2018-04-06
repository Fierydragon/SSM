package com.shiyanlou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shiyanlou.model.User;
import com.shiyanlou.service.UserService;


public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(User user, Model model, HttpSession session) {
		User loginUser = userService.login(user);
		
		if(null != loginUser) {
			session.setAttribute("user", loginUser);
			return "redirect:alluser";
		} else {
			model.addAttribute("message", "username or password is wrong!");
			return "loginform";
		}
	}
	
	@RequestMapping(value="/loginout")
	public String loginout(HttpSession session) {
		session.invalidate();
		
		return "loginform";
	}
	
	@RequestMapping("/alluser")
	public String selectAllUser(HttpServletRequest request) {
		List<User> listUser = userService.selectAllUser();
		request.setAttribute("listUser", listUser);
		return "userlist";
	}
	
	@RequestMapping("/toadduser")
	public String toAddUserPage() {
		return "adduser";
	}
	
	@RequestMapping("/toupdateuser")
	public String addUser(User user, HttpServletRequest request) {
		userService.addUser(user);
		List<User> listUser = userService.selectAllUser();
		request.setAttribute("listUser", listUser);
		return "userlist";
	}
	
	@RequestMapping("/toupdateuser")
	public String toUpdateUser(@Param("id") int id, HttpServletRequest request, Model model) {
		model.addAttribute("user_id", id);
		return "updateuser";
	}
	
	@RequestMapping("/updateuser")
	public String updateUser(User user, HttpServletRequest request) {
		userService.updateUser(user);
		List<User> listUser = userService.selectAllUser();
		request.setAttribute("listUser", listUser);
		return "userlist";
	}
	
	@RequestMapping("/deleteuser")
	public String deleteUser(@Param("id") int id, HttpServletRequest request) {
		userService.deleteUser(id);
		List<User> listUser = userService.selectAllUser();
		request.setAttribute("listUser", listUser);
		
		return "userlist";
	}
}
