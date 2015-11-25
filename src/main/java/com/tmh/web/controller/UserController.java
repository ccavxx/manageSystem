package com.tmh.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmh.web.domain.User;
import com.tmh.web.service.user.UserService;

@Controller
public class UserController {
	
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/user/create")
	public String createUser(HttpServletRequest request,Model model,User user){
		if("GET".equalsIgnoreCase(request.getMethod())){
			model.addAttribute("op","create" );
			return "user/user-form";
		}else{
			userService.create(user);
			return "redirect:/user/list";
		}
	}
	
	@RequestMapping("/user/list")
	public String showUser(HttpServletRequest request,Model model){
		List<User> userList = userService.findAll();
		model.addAttribute("userList",userList);
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("user",user);
		return "/user/user-list";
	}
	
	@RequestMapping("/user/update/{id}")
	public String update(HttpServletRequest request,Model model,User user,@PathVariable("id") Integer id){
		
		if("GET".equalsIgnoreCase(request.getMethod())){
			User u = userService.findById(id);
			model.addAttribute("op", "update");
			model.addAttribute("user", u);
			return "user/user-form";
		}
		userService.update(user);
		return "redirect:/user/list";
	}
	
	@RequestMapping("/user/delete/{id}")
	@ResponseBody
	public Boolean delete(@PathVariable("id") Integer id){
		return userService.deleteById(id);
	}
}
