package com.tmh.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

import com.tmh.web.common.Constants;


public class HtmlUtils {
	
	static final int TIME_OUT = 5000;
	
	private static Logger logger = Logger.getLogger(HtmlUtils.class);
	
	
	/**
	 * 抓取node节点
	 * @MethodName:getNodeListByTag
	 * @param url  抓取的url
	 * @param tag  html标签名称 table
	 * @param attribute  标签类型  class
	 * @param attributeName  标签类型名称    
	 * @return
	 * @return NodeList
	 * @author 田梦桦
	 * @Date 2014-11-19-上午11:09:12
	 */
	public static NodeList getNodeListByTag(String url,String tag,String attribute,String attributeName){
		try {
			HttpURLConnection conn = (HttpURLConnection) (new URL(url)).openConnection();
			conn.setRequestProperty("User-Agent","Mozilla/5.0 (compatible; Baiduspider/2.0; +http://www.baidu.com/search/spider.html)");
			conn.setConnectTimeout(TIME_OUT);
			conn.setReadTimeout(TIME_OUT);
			// 生成一个解析器对象，用网页的 url 作为参数
			Parser parser = new Parser(conn);
			// 设置网页的编码（UTF-8，GBK）
			parser.setEncoding("GBK");
			//根据标签去解析想要到的数据
			NodeFilter beginNodeFilter = new AndFilter(new TagNameFilter(tag),new HasAttributeFilter(attribute, attributeName));
			NodeList nodeList = parser.extractAllNodesThatMatch(beginNodeFilter);
			return nodeList;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("抓取的异常问题:" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 通过domain获取数据
	 * 设和json字符串
	 * @MethodName:getWebCon
	 * @param domain
	 * @return
	 * @return String
	 * @author TianMengHua
	 * @Date 2015年12月2日-下午3:59:07
	 */
	public static String getWebCon(String domain){
		StringBuffer sb = new StringBuffer();
		Integer responseCode = 0;
		java.net.URL url = null;
		try {
		    url = new java.net.URL(domain);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.111 Safari/537.36");
			conn.setConnectTimeout(TIME_OUT);
			conn.setReadTimeout(TIME_OUT);
			responseCode = conn.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
		} catch (Exception e) {
			 
			 if(Constants.HTTP_CONNECTION_ERROR_REQUEST.equals(responseCode)){
				 logger.error(domain+" [失败] [http code:]"+responseCode+" [原因:错误请求 — 请求中有语法问题，或不能满足请求。  ] [exception:]"+e.getMessage());
			 }
			 else if(Constants.HTTP_CONNECTION_OBJ_NOT_FOUND.equals(responseCode)){
				 logger.error(domain+" [失败] [http code:]"+responseCode+" [原因:服务器找不到给定的资源,文档不存在  ] [exception:]"+e.getMessage());
			 }
			 else if(Constants.HTTP_CONNECTION_OVERLOAD.equals(responseCode)){
				 logger.error(domain+"  [失败] [http code:]"+responseCode+" [原因:无法获得服务 — 由于临时过载或维护，服务器无法处理请求] [exception:]"+e.getMessage());
			 }
			 else if(Constants.HTTP_CONNECTION_TIMEOUT.equals(responseCode)){
			     logger.error(domain+" [失败] [http code:]"+responseCode+" [原因:网关超时  ] [exception:]"+e.getMessage());
				 return responseCode+"";
			 }else{
				  logger.warn(domain+"  [失败] [http code:]"+responseCode+" [exception:]"+e.getMessage());
				  return String.valueOf(responseCode);
			 }
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(getNodeListByTag("http://shbxcx.sn12333.gov.cn/", "h1", "class", "icon001").asString());
	}
}
