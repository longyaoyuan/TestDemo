package com.grouporg.dao;

import java.util.List;

import com.grouporg.entity.News;
import com.grouporg.entity.PageQuery;

/**
 * 新闻类接口
 * @author Administrator
 *
 */
public interface NewsDao {
	//增加
	public void addNews(News news);
	
	//根据新闻id修改新闻
	public void updateNewsById(News news);
	
	//删除新闻根据新闻id
	public void delNewsById(News news);
	
	//查询新闻列表
	public List<News> queryNewsList();
	
	//查询新闻根据新闻标题
	public News queryNewsByTitle(News news);
	
	//分页查询
	public List<News> queryListByLimit(PageQuery pageQuery);
	
	//根据新闻id添加新闻
	public News queryNewsById(String id);
	
	//查询数据的总记录数
	public int queryNewsCount();
	
}
