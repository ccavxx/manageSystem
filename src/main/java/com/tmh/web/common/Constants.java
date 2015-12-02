package com.tmh.web.common;

/**
 * 系统常量
 * className:Constants
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @CreateTime:2015年12月2日-下午3:57:49
 * @Remark 备注说明
 */
public class Constants {
	/**
	 * 成功状态
	 */
	public static final Integer HTTP_CONNECTION_SUCCESS = 200;
	
	/**
	 * 网关超时
	 */
	public static final Integer HTTP_CONNECTION_TIMEOUT = 504;
	
	/**
	 * 服务器找不到给定的资源,文档不存在
	 */
	public static final Integer HTTP_CONNECTION_OBJ_NOT_FOUND = 404;
	
	/**
	 * 无法获得服务 — 由于临时过载或维护，服务器无法处理请求
	 */
	public static final Integer HTTP_CONNECTION_OVERLOAD = 503;
	
	/**
	 * 错误请求 — 请求中有语法问题，或不能满足请求。  
	 */
	public static final Integer HTTP_CONNECTION_ERROR_REQUEST= 400;
}
