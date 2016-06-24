package com.tmh.web.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.tmh.utils.quartz.QuartzData;
import com.tmh.utils.quartz.QuartzUtils;

/**
 * 【工程名】
 *     manageSystem
 * 【类文件名称】
 *     BeanHolder.java
 * 【类文件描述】
 *			根据扫描到的类明获取bean
 *          如果扫描不到，包名全路径
 * 【历史信息】
 *      版本      日期      作者/修改者     内容描述
 *     -------- ---------   ---------- ------------------------
 *      1.0.0    2016年6月24日     TianMengHua        最初版本
 */
public class SpringContextHelper implements ApplicationContextAware{
		
		//spring上下文环境
	 	private static ApplicationContext context;
	
		/**
		 * 方法名：setApplicationContext
		 * 描述  ：
		 *		实现ApplicationContextAware接口的回调方法，设置上下文环境
		 * @param applicationContext
		 * @throws BeansException
		 */
	 	@Override
	    public void setApplicationContext(ApplicationContext applicationContext)
	        throws BeansException{
	 		context  = applicationContext;
	    }
	    
	    public static Object getBean(String name)
	        throws BeansException{
	        return context.getBean(name);
	    }
	    
}
