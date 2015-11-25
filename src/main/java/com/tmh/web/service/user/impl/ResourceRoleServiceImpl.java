package com.tmh.web.service.user.impl;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tmh.web.dao.user.ResourceRoleDao;
import com.tmh.web.domain.User;
import com.tmh.web.service.user.ResourceRoleService;
import com.tmh.web.service.user.UserRoleService;

@Service
@Transactional
public class ResourceRoleServiceImpl implements ResourceRoleService {

	@Resource
	private ResourceRoleDao resourceRoleDao;
	
	@Resource
	private UserRoleService userRoleService ;
	
	@Override
	public Set<String> find(User user) {
		Set<String> permissions = new HashSet<String>();
		Set<String> roleIds = resourceRoleDao.findResourceId(user.getId());
		for(String roleId : roleIds){
			permissions.addAll(resourceRoleDao.find(roleId));
		}
		return permissions;
	}

}
