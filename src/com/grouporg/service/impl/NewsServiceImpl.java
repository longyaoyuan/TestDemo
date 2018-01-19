package com.grouporg.service.impl;

import java.util.List;

import com.grouporg.dao.NewsDao;
import com.grouporg.dao.impl.NewsDaoImpl;
import com.grouporg.entity.News;
import com.grouporg.entity.PageQuery;
import com.grouporg.service.NewsService;

public class NewsServiceImpl implements NewsService{
		NewsDao newsDao =new NewsDaoImpl();
	//增加
	public void addNews(News news) {
		newsDao.addNews(news);
		
	}

	//根据新闻id修改新闻
	public void updateNewsById(News news) {
		newsDao.updateNewsById(news);
		
	}

	//根据新闻id删除新闻
	public void delNewsById(News news) {
		newsDao.delNewsById(news);
		
	}
	//查询新闻列表
	public List<News> queryNewsList() {
		
		return newsDao.queryNewsList();
	}

	//查询新闻根据新闻的标题
	public News queryNewsByTitle(News news) {
		
		return newsDao.queryNewsByTitle(news);
	}

	//分页查询
	public List<News> queryListByLimit(PageQuery pageQuery) {
		
		return newsDao.queryListByLimit(pageQuery);
	}

	//根据新闻id进行查询
	public News queryNewsById(String id) {
		
		return newsDao.queryNewsById(id);
	}

	//查询总的记录数
	public int queryNewsCount() {
		
		return newsDao.queryNewsCount();
	}


}
