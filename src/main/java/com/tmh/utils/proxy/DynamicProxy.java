package com.tmh.utils.proxy;

/**
 * 【工程名】
 *     manageSystem
 * 【类文件名称】
 *     DynamicProxy.java
 * 【类文件描述】
 *		动态代理
 * 【历史信息】
 *      版本      日期      作者/修改者     内容描述
 *     -------- ---------   ---------- ------------------------
 *      1.0.0    2017年2月10日     TianMengHua        最初版本
 */
public class DynamicProxy {
	public static void main(String[] args) {
		BusinessFooImpl bfoo = new BusinessFooImpl();
        BusinessFoo bf = (BusinessFoo)ProxyUtil.factory(bfoo);
        bf.foo();
	}
}
