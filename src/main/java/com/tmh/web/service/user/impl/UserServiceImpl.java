package com.tmh.web.service.user.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tmh.web.dao.user.UserDao;
import com.tmh.web.domain.User;
import com.tmh.web.service.realm.PasswordCreate;
import com.tmh.web.service.user.ResourceRoleService;
import com.tmh.web.service.user.UserRoleService;
import com.tmh.web.service.user.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	@Resource
	private PasswordCreate passwordCreate;
	@Resource
	private UserDao userDao;
	
	@Resource
	private UserRoleService userRoleService;

	@Resource
	private ResourceRoleService resourceRoleService;
	
	@Override
	public void create(User user) {
		passwordCreate.createPassword(user);
		user.setStatus("1");
		userDao.create(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void update(User user) {
		passwordCreate.createPassword(user);
		userDao.update(user);
	}

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public Boolean deleteById(Integer id) {
		Integer count = userDao.deleteById(id);
		return count==1?true:false;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Set<String> findRoles(String username) {
		User user = userDao.findByUsername(username);
		if(user==null){
			return Collections.EMPTY_SET;
		}
		return userRoleService.findRoleCode(user);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<String> findPermissions(String username) {
		User user = userDao.findByUsername(username);
		if(user==null){
			return Collections.EMPTY_SET;
		}
		return resourceRoleService.find(user);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
