package com.tmh.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.tmh.test.base.AbstractTest;
import com.tmh.web.dao.shard.ShardDao;

public class ShardDaoTest extends AbstractTest{
	
	@Autowired
	private ShardDao shardDao;
	
	@Test
	@Rollback(false)
	public void insert(){
		for(int i=0;i<1;i++){
			String name = "tmh" + i;
			shardDao.addShard(name);
		}
	}
	
}
