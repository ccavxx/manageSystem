package com.tmh.web.service.user;

import java.util.List;
import java.util.Set;

import com.tmh.web.domain.User;

public interface UserService {

	void create(User user);

	List<User> findAll();

	void update(User user);

	User findById(Integer id);

	Boolean deleteById(Integer id);

	Set<String> findRoles(String username);

	Set<String> findPermissions(String username);

	User findByUsername(String username);

}
