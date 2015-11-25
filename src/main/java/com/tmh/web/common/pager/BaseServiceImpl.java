package com.tmh.web.common.pager;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 
/**
 * 
 * className:BaseServiceImpl
 * @Description:TODO (文件说明：  Service基类）
 * @author TianMengHua 
 * @CreateTime:2015年9月28日-上午9:46:52
 * @Remark 备注说明
 * @param <E>
 */
public class BaseServiceImpl<E> implements BaseService<E> {
	
	private static  Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	/**
	 * 分页查询具体实现方法
	 */
	public Pager<E> findPagedList(Integer  amount, List<E> results, Pager<E> parameter) {
		if (parameter == null) {
			logger.info("查询到的结果集为空 ");
			return new Pager<E>();
		}
		if (amount != null && amount > 0) {
			logger.info("共有数据记录：" + amount + "条");
			parameter.setTotalItem(amount);
		} else{
			logger.info("没有符合条件的数据记录，0条");
			return new Pager<E>();
		}
		parameter.setList(results);
		return parameter;
	}
}
