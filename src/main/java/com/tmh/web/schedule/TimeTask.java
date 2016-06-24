package com.tmh.web.schedule;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.tmh.utils.quartz.QuartzData;

/**
 * 定时任务
 * className:TimeTask
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @CreateTime:2015年12月14日-上午10:41:08
 * @Remark 备注说明
 */
@Component
public class TimeTask {
	
	/**
	 * 方法名：scheduleTask
	 * 描述  ：
	 *	注解方式的定时任务
	 */
	@Scheduled(cron="0 33 15 ? * *")   
	public void scheduleTask(){
		System.out.println("开启计划任务" + LocalDateTime.now());
	}
	
	/**
	 * 方法名：scheduleTask1
	 * 描述  ：
	 *		自定义定时任务
	 * @param name
	 */
	public void scheduleTask1(QuartzData data){
		System.out.println("开启任务" + data.getObject().toString());
	}
}
