package com.tmh.web.service.user;

import java.util.Set;

import com.tmh.web.domain.User;

public interface UserRoleService {

	/**
	 * 查询用户的角色code
	 * @param user
	 * @return
	 */
	Set<String> findRoleCode(User user);

}
