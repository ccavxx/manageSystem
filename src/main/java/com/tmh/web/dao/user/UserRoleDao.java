package com.tmh.web.dao.user;

import java.util.Set;

import org.apache.ibatis.annotations.Select;

import com.tmh.web.dao.base.BaseDao;

public interface UserRoleDao extends BaseDao{
	
	@Select("select r.code from user_role ur,role r where " +
			"ur.user_id=#{id} and ur.role_id=r.id")
	Set<String> findRoleCode(Integer id);
	
}
