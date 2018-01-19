package com.grouporg.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;

import com.grouporg.dao.NewsDao;
import com.grouporg.dao.impl.NewsDaoImpl;
import com.grouporg.entity.News;
import com.grouporg.entity.PageQuery;

public class TestNewsDao {
	NewsDao newsDao=new NewsDaoImpl();
	/**
	 * 添加新闻
	 */
	@Test
	public void testAddNews() {
		
		News news=new News();
		news.setnId("014");
		news.setnTitle("贵阳市");
		news.setnTime(Timestamp.valueOf("2017-12-12 15:35:20"));
		news.setnContent("今天是星期六！");
		news.setnPblush("wenjie");
		news.setnModifyTime(Timestamp.valueOf("2017-12-10 15:20:00"));
		newsDao.addNews(news);
		
	}
	/**
	 * 修改
	 */
	@Test
	public void testupdate(){
		News news=new News();
		news.setnId("121123");
		news.setnTitle("凯里市");
		news.setnTime(Timestamp.valueOf("2017-01-26 15:35:20"));
		news.setnContent("今天是星期日！");
		news.setnPblush("张三");
		news.setnModifyTime(Timestamp.valueOf("2017-12-10 15:20:00"));
		newsDao.updateNewsById(news);
	}
		/**
		 * 删除新闻
		 */
	@Test
	public void testDelete(){
		
		News news=new News();
		news.setnId("08");
		
		newsDao.delNewsById(news);
	}
	
		/**
		 * 查询列表
		 */
	@Test
	public void testQueryList(){
		List<News> list=newsDao.queryNewsList();
		System.out.println(list.size());
	}
	
	/**
	 * 根据新闻标题查询新闻
	 */
	@Test
	public void testQueryNews(){
		News news=new News();
		news.setnId("121123");
		news.setnTitle("凯里市");
		News newsL=newsDao.queryNewsByTitle(news);
		System.out.println("新闻标题=="+newsL.getnTitle()+"\t新闻内容"+newsL.getnContent());
	}
	/**
	 * 分页查询
	 */
	@Test
	public void testQueryNewsLimit(){
		PageQuery pageQuery=new PageQuery();
		pageQuery.setCurrentPage(1);
		pageQuery.setPageSize(3);
		List<News> newList=newsDao.queryListByLimit(pageQuery);
		System.out.println(newList.size());
	}
	/**
	 * 查询总记录
	 */
	@Test
	public void testQueryCount(){
		
		int count=0;
		
		count=newsDao.queryNewsCount();
		
		System.out.println("总记录数："+count);
	}

}
