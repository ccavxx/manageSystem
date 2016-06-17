package com.tmh.web.schedule;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 * className:Task
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @CreateTime:2015年12月14日-上午10:41:08
 * @Remark 备注说明
 */
public class Task {
	
	@Scheduled(cron="0 0 10 ? * *")   
	public void scheduleTask(){
		System.out.println("开启计划任务" + LocalDateTime.now());
	}
}
