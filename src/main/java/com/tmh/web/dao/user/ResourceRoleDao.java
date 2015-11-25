package com.tmh.web.dao.user;

import java.util.Set;

import org.apache.ibatis.annotations.Select;

import com.tmh.web.dao.base.BaseDao;

public interface ResourceRoleDao extends BaseDao{
	@Select("select code from resource r,resource_role ru where " +
			"ru.role_id=#{id} and r.id = ru.resource_id")
	Set<String> find(String id);
	
	@Select("select rr.resource_id from user_role ur,resource_role rr where " +
			"ur.user_id=#{id} and ur.role_id=rr.role_id")
	Set<String> findResourceId(Integer id);

}
