package com.tmh.web.dao.shard;

import org.apache.ibatis.annotations.Insert;

import com.tmh.web.dao.base.BaseDao;

public interface ShardDao extends BaseDao{
	
	@Insert("INSERT INTO shard_test (name) VALUES (#{name})")
	public void addShard(String name);
	
	
}
