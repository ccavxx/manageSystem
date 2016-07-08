package com.tmh.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.tmh.test.base.AbstractTest;
import com.tmh.web.dao.shard.ShardDao;

public class ShardDaoTest extends AbstractTest{
	
	@Autowired
	private ShardDao shardDao;
	
//	@Test
//	@Rollback(false)
	public void insert(){
		for(int i=0;i<10;i++){
			String name = "tmh" + i;
			shardDao.addShard(name);
		}
	}
	
	@Test
	public void getShard(){
		//获取每一个分表的数据
		List<String> allDataList = shardDao.getAllShard(0);
		List<String> allDataList1 = shardDao.getAllShard(1);
		List<String> allDataList2 = shardDao.getAllShard(2);
		
		System.out.println("查询数据数量：" + allDataList.size());
		System.out.println("查询数据数量：" + allDataList1.size());
		System.out.println("查询数据数量：" + allDataList2.size());
	}
	
}
