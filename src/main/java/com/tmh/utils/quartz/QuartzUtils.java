package com.tmh.utils.quartz;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 【工程名】
 *     manageSystem
 * 【类文件名称】
 *     QuartzUtils.java
 * 【类文件描述】
 *     		定时任务工具包(shiro定时版本的冲突问题)
 *
 * 【历史信息】
 *      版本      日期      作者/修改者     内容描述
 *     -------- ---------   ---------- ------------------------
 *      1.0.0    2016年6月18日     TianMengHua        最初版本
 */
public class QuartzUtils implements Job{
	
	private static SchedulerFactory factory = new StdSchedulerFactory();
	
    /**
     * 调用定时任务执行方法
     */
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
	}
	
	/**
	 * 添加一个定时任务
	 * @param jobName      任务名称
	 * @param className    类的包路径
	 * @param methodName   方法名称
	 * @param intervalTime 时间
	 * @return
	 */
	public static Boolean addJob(String jobName,String taskClass,String taskMethod, String intervalTime,QuartzData data) {
		try {
			// 从工厂里面拿到一个scheduler实例
			Scheduler scheduler = factory.getScheduler();
			// 创建一个新的job（只包含业务代码）
			JobDetail job = JobBuilder.newJob(QuartzUtils.class)
					.withIdentity(jobName).build();
			// 创建一个新的触发器（设定任务的执行时间<crontab时间格式>）
			CronTrigger trigger = TriggerBuilder.newTrigger()
					.withIdentity(jobName + "_trigger")
					.withSchedule(CronScheduleBuilder.cronSchedule(intervalTime))
					.build();
			job.getJobDataMap().put("quartzData", data);
			job.getJobDataMap().put("taskClass", taskClass);
			job.getJobDataMap().put("taskMethod", taskMethod);
			// 将任务和Trigger放入scheduler
			scheduler.scheduleJob(job, trigger);
			// 执行定时任务
			scheduler.start();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 暂停一个定时任务 
	 */
	public static Boolean stopJob(String jobName) {
		try {
			Scheduler scheduler = factory.getScheduler();
			JobKey jobKey=new JobKey(jobName);
			TriggerKey triggerKey=new TriggerKey(jobName + "_trigger");
			scheduler.pauseTrigger(triggerKey);// 停止触发器
			scheduler.pauseJob(jobKey);;// 停止任务
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 暂停多个定时任务 
	 */
	public static Boolean stopJobs(List<String> jobNames) {
		try {
			Scheduler scheduler = factory.getScheduler();
			if(jobNames!=null && jobNames.size()>0){
				for(String jobName:jobNames){
					JobKey jobKey=new JobKey(jobName);
					TriggerKey triggerKey=new TriggerKey(jobName + "_trigger");
					scheduler.pauseTrigger(triggerKey);// 停止触发器
					scheduler.pauseJob(jobKey);;// 停止任务
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 恢复一个定时任务 
	 */
	public static Boolean resumeJob(String jobName) {
		try {
			Scheduler scheduler = factory.getScheduler();
			JobKey jobKey=new JobKey(jobName);
			TriggerKey triggerKey=new TriggerKey(jobName + "_trigger");
			scheduler.resumeTrigger(triggerKey);// 停止触发器
			scheduler.resumeJob(jobKey);// 停止任务
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 恢复多个定时任务 
	 */
	public static Boolean resumeJobs(List<String> jobNames) {
		try {
			Scheduler scheduler = factory.getScheduler();
			if(jobNames!=null && jobNames.size()>0){
				for(String jobName:jobNames){
					JobKey jobKey=new JobKey(jobName);
					TriggerKey triggerKey=new TriggerKey(jobName + "_trigger");
					scheduler.resumeTrigger(triggerKey);// 停止触发器
					scheduler.resumeJob(jobKey);;// 停止任务
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 停止结束一个定时任务 
	 */
	public static Boolean removeJob(String jobName) {
		try {
			Scheduler scheduler = factory.getScheduler();
			JobKey jobKey=new JobKey(jobName);
			TriggerKey triggerKey=new TriggerKey(jobName + "_trigger");
			scheduler.pauseTrigger(triggerKey);// 停止触发器
			scheduler.unscheduleJob(triggerKey);// 移除触发器
			scheduler.pauseJob(jobKey);;// 停止任务
			scheduler.deleteJob(jobKey);// 删除任务
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除多个定时任务 
	 */
	public static Boolean removeJobs(List<String> jobNames) {
		try {
			Scheduler scheduler = factory.getScheduler();
			if(jobNames!=null && jobNames.size()>0){
				for(String jobName:jobNames){
					JobKey jobKey=new JobKey(jobName);
					TriggerKey triggerKey=new TriggerKey(jobName + "_trigger");
					scheduler.pauseTrigger(triggerKey);// 停止触发器
					scheduler.unscheduleJob(triggerKey);// 移除触发器
					scheduler.pauseJob(jobKey);;// 停止任务
					scheduler.deleteJob(jobKey);// 删除任务
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 修改一个定时任务的时间 
	 */
	public static Boolean updateJob(String jobName, String intervalTime) {
		try {
			Scheduler scheduler = factory.getScheduler();
			JobKey jobKey=new JobKey(jobName);
			JobDetail job=scheduler.getJobDetail(jobKey);
			TriggerKey triggerKey=new TriggerKey(jobName + "_trigger");
			scheduler.pauseTrigger(triggerKey);// 停止触发器
			scheduler.unscheduleJob(triggerKey);// 移除触发器
			scheduler.pauseJob(jobKey);;// 停止任务
			scheduler.deleteJob(jobKey);// 删除任务
			CronTrigger trigger = TriggerBuilder.newTrigger()
					.withIdentity(jobName + "_trigger")
					.withSchedule(CronScheduleBuilder.cronSchedule(intervalTime))
					.build();
			scheduler.scheduleJob(job,trigger);
			scheduler.start();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		QuartzData quartzData = new QuartzData();
		quartzData.setObject("我是参数");
		QuartzUtils.addJob("自定义定时任务", "com.tmh.web.schedule.Task", "scheduleTask1", "0 8 16 ? * *", quartzData);
	}
	
}
