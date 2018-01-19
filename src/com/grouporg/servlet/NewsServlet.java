package com.grouporg.servlet;

import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.grouporg.entity.News;
import com.grouporg.service.NewsService;
import com.grouporg.service.impl.NewsServiceImpl;

public class NewsServlet extends HttpServlet {

	
	NewsService newsService=new NewsServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
			
		//根据表单提交的方法参数，来确定调用哪个方法
		String method=request.getParameter("method");
		System.out.println("method=="+method);
			if("editor".equals(method)){
				//调用新闻编辑方法
				newsEditor(request,response);
				
			}else if("newsList".equals(method)){
				//调用查询列表的方法
				queryNewsList(request,response);	
			}else if("queryNewsByTitle".equals(method)){
				//根据新闻标题查询
				queryNewsByTitle(request, response);
			}else if("queryNewsByTitles".equals(method)){
				//根据新闻Id查询
				queryNewsById(request, response);
			}			
}			
		
		/**
		 * 查询列表
		 * @param request
		 * @param response
		 * @throws IOException
		 */
	private void queryNewsList(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			//调用业务控制层
			List<News> newsList=new ArrayList<News>();	
			newsList=newsService.queryNewsList();
			
			//把数据放入session域中
			HttpSession session=request.getSession();	
			session.setAttribute("newsList", newsList);
			
			//遍历查询的结果集
			for (int i = 0; i <newsList.size(); i++) {
				Timestamp newsTime=newsList.get(i).getnTime();
				int month=newsTime.getMonth();
				session.setAttribute("month", month);
			}
			//运行提示
			System.out.println("查询列表已经开始！");		
			//跳转
			response.sendRedirect("/GroupOrg/home.jsp");
	}
		
		/**
		 * 新闻编辑
		 * @param request
		 * @param response
		 * @throws IOException
		 */
	public void newsEditor(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			//获取jsp表单 参数内容
			
			String newsTitle=request.getParameter("title");
			String newsTime=request.getParameter("time");
			String newsPblush=request.getParameter("pbush");
			String newsContent=request.getParameter("container");
			
			//String类型的时间转换成timeStamp类型
			Timestamp newsdate=Timestamp.valueOf(newsTime);
			
			//对获取的内容进行封装
			News news=new News();
			news.setnId("2018news");
			news.setnTitle(newsTitle);
			news.setnTime(newsdate);
			news.setnContent(newsContent);
			news.setnPblush(newsPblush);
			
			//调用后台方法，保存到数据数据库中
			newsService.addNews(news);
			/*
			//将封装后的对象放入集合中
			List<News> newsList=new  ArrayList<News>();
			newsList.add(news);
			
			//将集合放置到session域中
			HttpSession session=request.getSession();
			session.setAttribute("newsList", newsList);
			
			*/
			
			//进行页面跳转
			response.sendRedirect("newDetils.jsp");

			//向后台输出
			System.out.println("内容："+newsContent);
	}
	/**
	 * 根据新闻Id查询新闻
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	public void queryNewsByTitle(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setCharacterEncoding("UTF-8");
	
			                  
			
	}
	
	/**
	 * 根据新闻id查询
	 */
	public void queryNewsById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//响应编码格式UTF-8
		response.setCharacterEncoding("UTF-8");
		//获取页面转过来的数据
		String id=request.getParameter("id");
		
		System.out.println("新闻id:"+id);
		//调用后台方法
		News news=newsService.queryNewsById(id);
		List<News> newslist=new ArrayList<News>();
		newslist.add(news);
		//对后台查询出来的数据放入session中
		HttpSession session=request.getSession();
		session.setAttribute("NewsList",newslist);
		
		//页面的跳转
		response.sendRedirect("../GroupOrg/newDetils.jsp");		
	}
	
	
	
}
