package com.tmh.web.dao.shard;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.tmh.web.dao.base.BaseDao;

public interface ShardDao extends BaseDao{
	
	@Insert("INSERT INTO shard_test (name) VALUES (#{name})")
	public void addShard(String name);
	
	@Select("SELECT name FROM shard_test_#{params}")
	public List<String> getAllShard(Object params);
	
	@Select("SELECT count(*) FROM shard_test")
	public Integer getCountShard();
	
	
}
