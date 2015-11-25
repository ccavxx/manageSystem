package com.tmh.web.common.pager;

import java.util.List;
 
/**
 * 
 * className:BaseService
 * @Description:TODO (文件说明： Service基类接口，封装了分页查询）
 * @author TianMengHua 
 * @CreateTime:2015年9月28日-上午9:45:46
 * @Remark 备注说明
 * @param <E>
 */
public interface BaseService<E>  {
	
	/**
	 * 
	 * @MethodName:findPagedList  分页查询具体实现方法
	 * @param amount 数据记录总数
	 * @param results 每页的数据list
	 * @param parameter 分页参数
	 * @return Pager<E>
	 * @author TianMengHua
	 * @Date 2015年9月28日-上午9:46:25
	 */
	public Pager<E> findPagedList(Integer  amount, List<E> results, Pager<E> parameter);
}
