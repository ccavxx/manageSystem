package com.tmh.web.service.user;

import java.util.Set;

import com.tmh.web.domain.User;

public interface ResourceRoleService {

	Set<String> find(User user);

}
