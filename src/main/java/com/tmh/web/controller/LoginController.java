package com.tmh.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tmh.web.annotation.Log;
import com.tmh.web.domain.User;

@Controller
public class LoginController {
	
	@Log(name = "登录")
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
//		QuartzData quartzData = new QuartzData();
//		quartzData.setObject("我是参数");
//		QuartzUtils.addJob("自定义定时任务", "timeTask", "scheduleTask1", "0 19 11 ? * *", quartzData);
		return "login";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String login(HttpServletRequest request,Model model){
		String exceptionName = (String)request.getAttribute("shiroLoginFailure");//登陆失败会把异常写入该属性
		String error = null;
		if(UnknownAccountException.class.getName().equals(exceptionName)){//账号不存在
			error = "没有找到账号";
		}else if(IncorrectCredentialsException.class.getName().equals(exceptionName)){//密码错误
			error = "用户名或者密码错误";
		}else if(DisabledAccountException.class.getName().equals(exceptionName)){//账号禁用
			error = "账号禁用";
		}else if(ExcessiveAttemptsException.class.getName().equals(exceptionName)){//账号禁用
			error = "错误次数太多";
		}else if(LockedAccountException.class.getName().equals(exceptionName)){//账号状态为2
			error = "用户的状态为2";
		}else if(exceptionName!=null){
			error = "未知错误";
		}
		model.addAttribute("error", error);
		return "login";
	}
	
	@Log(name = "首页")
	@RequestMapping(value="index")
	public String index(HttpServletRequest request,Model model,String username){
		model.addAttribute("username",username);
		return "index";
	}
	
	@RequestMapping(value="403")
	public String err403(HttpServletRequest request,Model model){
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("user",user);
		return "403";
	}
	
	/**
	 * 退出登录
	 * @MethodName:logout
	 * @return void
	 * @author TianMengHua
	 * @Date 2015年11月7日-上午10:34:15
	 */
	@RequestMapping(value="logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		}
		return "login";
	}
}
