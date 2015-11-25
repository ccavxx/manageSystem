package com.tmh.web.dao.news;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tmh.web.dao.base.BaseDao;
import com.tmh.web.domain.News;

public interface NewsDao extends BaseDao{
	
	/**
	 * 统计新闻总数
	 * @MethodName:getCountByNews
	 * @param news
	 * @return
	 * @return Integer
	 * @author TianMengHua
	 * @Date 2015年10月9日-上午10:52:30
	 */
	@Select("select count(1) from news")
	public Integer getCountByNews(News news);
	
	/**
	 * 分页获取新闻列表
	 * @MethodName:getNewsList
	 * @param map
	 * @return
	 * @return List<News>
	 * @author TianMengHua
	 * @Date 2015年10月9日-上午10:52:13
	 */
	@Select("select * from news limit #{startRow},#{pageSize}")
	public List<News> getNewsList(Map<String, Object> map);
	
	/**
	 * 增加新闻
	 * @MethodName:addNews
	 * @param news
	 * @return void
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午12:03:12
	 */
	@Insert("INSERT INTO news ( id,title,newsType,content) VALUE " +
			"(#{id},#{title},#{newsType},#{content})")
	public void addNews(News news);
	
	/**
	 * 根据id删除新闻
	 * @MethodName:deleteNewsById
	 * @param id
	 * @return void
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午2:05:00
	 */
	@Delete("DELETE fROM news WHERE id=#{id}")
	public void deleteNewsById(Integer id);
	
	/**
	 * 根据id更新新闻
	 * @MethodName:updateNewsById
	 * @param id
	 * @return void
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午2:31:20
	 */
	@Update("UPDATE news SET title=#{title},content=#{content},newsType=#{newsType} WHERE id=#{id}")
	public void updateNewsById(News news);
	
	/**
	 * 根据id查找对应的新闻
	 * @MethodName:findNewsById
	 * @param id
	 * @return
	 * @return News
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午2:44:33
	 */
	@Select("SELECT * FROM news WHERE id=#{id}")
	public News findNewsById(Integer id);
	
}
