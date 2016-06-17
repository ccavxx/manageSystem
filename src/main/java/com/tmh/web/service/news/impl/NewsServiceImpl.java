package com.tmh.web.service.news.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tmh.web.annotation.Log;
import com.tmh.web.common.pager.BaseServiceImpl;
import com.tmh.web.common.pager.Pager;
import com.tmh.web.dao.news.NewsDao;
import com.tmh.web.domain.News;
import com.tmh.web.service.news.NewsService;

@Service
@Transactional
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

	
	@Autowired
	private NewsDao newsDao;


	@Override
	public Integer getCountByArticle(News news) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("news", news);
		return newsDao.getCountByNews(news);
	}
	
	@Log(name="新闻列表")
	@Override
	public List<News> getNewsList(Pager<News> pager, News news) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startRow", pager.getStartRow());
		map.put("pageSize", pager.getPageSize());
		map.put("news", news);
		return newsDao.getNewsList(map);
	}

	@Override
	public void addNews(News news) {
		newsDao.addNews(news);
	}

	@Override
	public void deleteNewsById(Integer id) {
		newsDao.deleteNewsById(id);
	}

	@Override
	public void updateNewsById(News news) {
		newsDao.updateNewsById(news);
	}

	@Override
	public News findNewsById(Integer id) {
		return newsDao.findNewsById(id);
	}

}
