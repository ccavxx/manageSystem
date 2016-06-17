package com.tmh.web.aop;

import java.lang.reflect.Method;
import java.util.UUID;
 





import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.tmh.web.annotation.Log;

/**
 * 【工程名】
 *     manageSystem
 * 【类文件名称】
 *     WebLogAspect.java
 * 【类文件描述】
 *     	实现Web层的日志切面
 *			
 * 【历史信息】
 *      版本      日期      作者/修改者     内容描述
 *     -------- ---------   ---------- ------------------------
 *      1.0.0    2016年6月16日     TianMengHua        最初版本
 */
@Component
@Aspect
public class LogAop {
	 
	 ThreadLocal<Long> time=new ThreadLocal<Long>();
	 ThreadLocal<String> tag=new ThreadLocal<String>();
	 
	 @Pointcut("@annotation(com.tmh.web.annotation.Log)")
	 //@Pointcut("execution(public * *(..))")
     public void webLog(){
        System.out.println("我是一个切入点");
     }
	 
	 /**
	  *	在所有标注@Log的地方切入
	  * @param joinPoint
	  */
     @Before(value ="webLog()")
     public void doBefore(JoinPoint joinPoint){
    	 time.set(System.currentTimeMillis());
         tag.set(UUID.randomUUID().toString());
          
         info(joinPoint);
          
         MethodSignature ms=(MethodSignature) joinPoint.getSignature();
         Method method=ms.getMethod();
         System.out.println(method.getAnnotation(Log.class).name()+"标记"+tag.get());
     }
     
     @After("webLog()")
     public void afterExec(JoinPoint joinPoint){
         MethodSignature ms=(MethodSignature) joinPoint.getSignature();
         Method method=ms.getMethod();
         System.out.println("标记为"+tag.get()+"的方法"+method.getName()+"运行消耗"+(System.currentTimeMillis()-time.get())+"ms");
     }
      
     @Around("com.tmh.web.service.news.impl.NewsServiceImpl.getNewsList()")
     public void aroundExec(ProceedingJoinPoint pjp) throws Throwable{
         System.out.println("我是Around，来打酱油的");
         pjp.proceed();
     }
     
     private void info(JoinPoint joinPoint){
         System.out.println("--------------------------------------------------");
         System.out.println("King:\t"+joinPoint.getKind());
         System.out.println("Target:\t"+joinPoint.getTarget().toString());
         Object[] os=joinPoint.getArgs();
         System.out.println("Args:");
         for(int i=0;i<os.length;i++){
             System.out.println("\t==>参数["+i+"]:\t"+os[i].toString());
         }
         System.out.println("Signature:\t"+joinPoint.getSignature());
         System.out.println("SourceLocation:\t"+joinPoint.getSourceLocation());
         System.out.println("StaticPart:\t"+joinPoint.getStaticPart());
         System.out.println("--------------------------------------------------");
     }
}
