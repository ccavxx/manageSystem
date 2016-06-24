package com.tmh.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 【工程名】
 *     manageSystem
 * 【类文件名称】
 *     DiffController.java
 * 【类文件描述】
 *     		对比页面
 *
 * 【历史信息】
 *      版本      日期      作者/修改者     内容描述
 *     -------- ---------   ---------- ------------------------
 *      1.0.0    2016年6月24日     TianMengHua        最初版本
 */
@Controller
public class DiffController {
	
	/**
	 * 方法名：diff
	 * 描述  ：
	 *		跳转到版本比较页面
	 * @return
	 */
	@RequestMapping("/diff")
	public String diff(){
		//后台传递版本号和内容省略，格式参照前台
		return "/diff/diff";
	}
	
}
