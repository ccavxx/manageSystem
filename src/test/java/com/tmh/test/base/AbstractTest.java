package com.tmh.test.base;


import org.junit.BeforeClass;
import org.junit.runner.RunWith;  
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.TestExecutionListeners;  
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;  
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;  
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;  
import org.springframework.transaction.annotation.Transactional;


 
@RunWith(SpringJUnit4ClassRunner.class)

 
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)

 
@Transactional

 
@TestExecutionListeners( { TransactionalTestExecutionListener.class, DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class })


/**
 * 测试注解效果，读取配置文件获取bean
 * className:AbstractTest
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @CreateTime:2015年11月26日-上午11:39:16
 * @Remark 备注说明
 */
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class AbstractTest extends AbstractJUnit4SpringContextTests  {
	
	@BeforeClass
	static public void onSetUp() throws Exception {
		System.out.println("====================   before =======================");
		MockServletContext context = new MockServletContext();
		System.getProperty("WHICH_DB_JAVA_POOL", "dist");
	}

}


