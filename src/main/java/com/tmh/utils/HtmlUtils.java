package com.tmh.utils;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;


public class HtmlUtils {
	
	static final int TIME_OUT = 5000;
	
	private static Logger logger = Logger.getLogger(HtmlUtils.class);
	
	
	/**
	 * 
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
	
	public static void main(String[] args) {
		System.out.println(getNodeListByTag("http://shbxcx.sn12333.gov.cn/", "h1", "class", "icon001").asString());
	}
}
