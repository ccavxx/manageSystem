package com.tmh.web.core;

import java.util.Random;

import com.google.code.shardbatis.strategy.ShardStrategy;

/**
 * 【工程名】
 *     manageSystem
 * 【类文件名称】
 *     Shardstrategyimpl.java
 * 【类文件描述】
 *     		简单的实现修改表名的逻辑
 *
 * 【历史信息】
 *      版本      日期      作者/修改者     内容描述
 *     -------- ---------   ---------- ------------------------
 *      1.0.0    2016年7月5日     TianMengHua        最初版本
 */
public class ShardStrategyImpl implements ShardStrategy{

	@Override
	public String getTargetTableName(String baseTableName, Object params,
			String mapperId) {
		//新增的时候分表策略
		if(mapperId.contains("addShard")){
			Random random = new Random();
			int k = random.nextInt(10);
			k = k%3;
			return baseTableName+"_" + k;
		}else{
			return baseTableName+"_" + params;
		}
		
	}

}
