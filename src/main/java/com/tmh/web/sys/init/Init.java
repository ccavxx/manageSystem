package com.tmh.web.sys.init;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

@Component
//@Lazy(true)    //是否懒加载
public class Init implements InitializingBean,ServletContextAware{

	public void afterPropertiesSet() throws Exception {
		System.out.println("spring初始化操作");
	}

	@Override
	public void setServletContext(ServletContext sc) {
		sc.setAttribute("key", "value");
		sc.getAttribute("key");
	}

}
