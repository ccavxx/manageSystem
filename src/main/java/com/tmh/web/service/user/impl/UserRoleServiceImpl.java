package com.tmh.web.service.user.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tmh.web.dao.user.ResourceRoleDao;
import com.tmh.web.dao.user.UserRoleDao;
import com.tmh.web.domain.User;
import com.tmh.web.service.user.UserRoleService;
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService{

	@Resource
	private ResourceRoleDao resourceRoleDao;
	
	@Resource
	private UserRoleDao userRoleDao;

	@Override
	public Set<String> findRoleCode(User user) {
		return userRoleDao.findRoleCode(user.getId());
	}

}
