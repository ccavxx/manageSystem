package com.tmh.web.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻
 * className:News
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @CreateTime:2015年10月9日-上午11:31:10
 * @Remark 备注说明
 */
public class News implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482953178651233875L;
	
	private Integer id;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 作者
	 */
	private String author;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 排序
	 */
	private Integer orderNo;
	
	/**
	 * 分类(1.公司新闻   2.行业动态)
	 */
	private Integer newsType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getNewsType() {
		return newsType;
	}

	public void setNewsType(Integer newsType) {
		this.newsType = newsType;
	}
	
}
