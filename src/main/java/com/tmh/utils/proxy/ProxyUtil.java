package com.tmh.utils.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 【工程名】
 *     manageSystem
 * 【版权所有】
 *     Copyright ? 2017 启明星辰  电信产品事业部
 * 【类文件名称】
 *     Proxy.java
 * 【类文件描述】
 *     代理工具类
 *
 * 【历史信息】
 *      版本      日期      作者/修改者     内容描述
 *     -------- ---------   ---------- ------------------------
 *      1.0.0    2017年2月10日     TianMengHua        最初版本
 */
public class ProxyUtil implements InvocationHandler{
	
	private Object obj;
	
	ProxyUtil(){
	}
	
	ProxyUtil(Object obj) {
        this.obj = obj;
    }
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
        doBefore();
        result = method.invoke(obj,args);
        doAfter();
        return result;
	}
	
	public void doBefore(){
        System.out.println("do something before Business Logic");
    }
    public void doAfter(){
        System.out.println("do something after Business Logic");
    }
    
    public static Object factory(Object obj){
        Class<? extends Object> cls = obj.getClass();
        return Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(),new ProxyUtil(obj));
    }

}
