package com.tmh.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tmh.web.common.pager.Pager;
import com.tmh.web.domain.News;
import com.tmh.web.service.news.NewsService;


@Controller
@RequestMapping(value = "/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value="list")
	public String list(Model model,Integer toPage,Integer totalItem,News news){
		Pager<News> pager = new Pager<News>();
		List<News> list = new ArrayList<News>();		
		Integer amount = 0;
		if(toPage!=null){
			 pager.setToPage(toPage);
			 pager.setTotalItem(totalItem);
		}
		amount = newsService.getCountByArticle(news);
		list = newsService.getNewsList(pager,news);

		pager = newsService.findPagedList(amount, list, pager);
		model.addAttribute("pager", pager);
		return "news/news-list";
	}
	
	/**
	 * 跳转到增加新闻页面
	 * @MethodName:addNews
	 * @return
	 * @return String
	 * @author TianMengHua
	 * @Date 2015年10月15日-上午11:39:04
	 */
	@RequestMapping(value="add",method = RequestMethod.GET)
	public String addNews(){
		return "news/news-form";
	}
	
	/**
	 * 跳转到更新新闻页面
	 * @MethodName:updateNews
	 * @return
	 * @return String
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午2:41:45
	 */
	@RequestMapping(value="updatePage")
	public String updateNewsPage(Model model,Integer id){
		News news = newsService.findNewsById(id);
		model.addAttribute(news);
		return "news/news-form";
	}
	
	/**
	 * 增加新闻
	 * @MethodName:addNews
	 * @param news
	 * @return
	 * @return String
	 * @author TianMengHua
	 * @Date 2015年10月15日-上午11:39:41
	 */
	@RequestMapping(value="add",method = RequestMethod.POST)
	@ResponseBody
	public String addNews(News news){
		String flag = "true";
		try {
			newsService.addNews(news);
		} catch (Exception e) {
			flag = "false";
		}
		return flag;
	}
	
	/**
	 * 根绝id删除新闻
	 * @MethodName:deleteNews
	 * @param id
	 * @return
	 * @return String
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午2:25:01
	 */
	@RequestMapping(value="delete",method = RequestMethod.POST)
	@ResponseBody
	public String deleteNews(Integer id){
		String flag = "true";
		try {
			newsService.deleteNewsById(id);
		} catch (Exception e) {
			flag = "false";
		}
		return flag;
	}
	
	/**
	 * 根据新闻Id更新新闻
	 * @MethodName:updateNews
	 * @param id
	 * @return
	 * @return String
	 * @author TianMengHua
	 * @Date 2015年10月15日-下午2:25:56
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public String updateNews(News news){
		String flag = "true";
		try {
			newsService.updateNewsById(news);
		} catch (Exception e) {
			flag = "false";
		}
		return flag;
	}
	
	
}
