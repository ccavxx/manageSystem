package com.tmh.utils;

import java.io.BufferedInputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

/**
 * 代理IP集成和处理
 * className:AgentIPUtils
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @CreateTime:2015年12月8日-下午4:34:50
 * @Remark 备注说明
 */
public class AgentIPUtils {
	
	private static Logger logger = Logger.getLogger(AgentIPUtils.class);
	
	/**
	 * 启动代理ip
	 * @MethodName:agentIP
	 * @return void
	 * @author TianMengHua
	 * @Date 2015年12月2日-下午4:24:09
	 */
	public static void agentIP(String ip,String port){
		//设置代理
		System.getProperties().setProperty("proxySet", "true"); //如果不设置，只要代理IP和代理端口正确,此项不设置也可以
		System.getProperties().setProperty("http.proxyHost", ip);
		System.getProperties().setProperty("http.proxyPort", port);
		System.out.println("启用代理IP:" + System.getProperty("http.proxyHost") + " port:" + System.getProperty("http.proxyPort"));
		logger.info("启用代理IP:" + System.getProperty("http.proxyHost") + " port:" + System.getProperty("http.proxyPort"));
	}
	
	/**
	 * 查看代理IP地址(减少访问压力，仅供测试使用)
	 * 新HtmlUtils提供抓取的IP的方法
	 * @MethodName:getHtml
	 * @param address  http://city.ip138.com/ip2city.asp
	 * @return
	 * @return String
	 * @author TianMengHua
	 * @Date 2015年12月8日-下午4:22:12
	 */
	public static String getIPAdressForHtml(String address){
		StringBuffer html = new StringBuffer();
		String result = null;
		try{
			URL url = new URL(address);
			URLConnection conn = url.openConnection();
			conn.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; GTB5; .NET CLR 2.0.50727; CIBA)");
			BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
		try {
			String inputLine;
			byte[] buf = new byte[4096];
			int bytesRead = 0;
			while (bytesRead >= 0) {
				inputLine = new String(buf, 0, bytesRead, "ISO-8859-1");
				html.append(inputLine);
				bytesRead = in.read(buf);
				inputLine = null;
		}
			buf = null;
		} finally {
			in.close();
			conn = null;
			url = null;
		}
			result = new String(html.toString().trim().getBytes("ISO-8859-1"), "gb2312").toLowerCase();
		}catch(Exception e){
			System.out.println("异常问题：" + e.getMessage());
			return null;
		}
			html = null;
			System.out.println(result);
			return result;
	}
}
