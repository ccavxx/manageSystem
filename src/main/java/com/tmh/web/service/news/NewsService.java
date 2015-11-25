package com.tmh.web.service.news;

import java.util.List;

import com.tmh.web.common.pager.BaseService;
import com.tmh.web.common.pager.Pager;
import com.tmh.web.domain.News;

public interface NewsService extends BaseService<News>{
	
	/**
	 * 根据规则统计新闻总数
	 * @MethodName:getCountByArticle
	 * @param news
	 * @return
	 * @return Integer
	 * @author TianMengHua
	 * @Date 2015年10月9日-上午10:45:05
	 */
	public Integer getCountByArticle(News news);
	
	/**
	 * 分页获取新闻列表
	 * @MethodName:getNewsList
	 * @param pager
	 * @param news
	 * @return
	 * @return List<News>
	 * @author TianMengHua
	 * @Date 2015年10月9日-上午10:45:38
	 */
	public List<News> getNewsList(Pager<News> pager, News news);
	
	/**
	 * 新增新闻
	 * @MethodName:addNews
	 * @param news
	 * @return
	 * @return boolean
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午12:01:27
	 */
	public void addNews(News news);
	
	/**
	 * 根据id删除新闻
	 * @MethodName:deleteNewsById
	 * @param id
	 * @return void
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午2:03:33
	 */
	public void deleteNewsById(Integer id);
	
	/**
	 * 根据id更新新闻
	 * @MethodName:updateNewsById
	 * @param id
	 * @return void
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午2:30:29
	 */
	public void updateNewsById(News news);
	
	/**
	 * 根据id查找新闻
	 * @MethodName:findNewsById
	 * @param id
	 * @return
	 * @return News
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午2:43:42
	 */
	public News findNewsById(Integer id);
}
