package com.grouporg.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grouporg.entity.News;
import com.grouporg.entity.PageQuery;
import com.grouporg.service.NewsService;
import com.grouporg.service.PageQueryService;
import com.grouporg.service.impl.NewsServiceImpl;
import com.grouporg.service.impl.PageQueryServiceImpl;
public class NewsCenter extends HttpServlet {
	
	NewsService newsService=new NewsServiceImpl();	
	PageQueryService pageQueryService= new PageQueryServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String method=request.getParameter("method");
		
		if("newsPageList".equals(method)){
			//分页查询新闻列表
			newsPageList(request, response);
			
		}else if("prePage".equals(method)){
			//上一页
			prePage(request, response);
			
		}else if("nextPage".equals(method)){
			//下一页
			nextPage(request, response);
			
		}
			
	}
	
	/**
	 * 分页查询新闻列表
	 * @param request
	 * @param response
	 */
	public void newsPageList(HttpServletRequest request, HttpServletResponse response){
				//参数
				int currentPage1=1;
				int totalPages=0;
				int pageSize=6;
				int beginIndex=0;
				int firstPage=1;
				int nextPage=0;
		//获取当前页
		String currentPage=request.getParameter("currentPage");
		System.out.println("当前页="+currentPage);
		if(currentPage==null||currentPage==""){
			 currentPage1=1;
			
		}else {
			currentPage1=Integer.parseInt(currentPage);		
		}
		
		
		
		
		
		HttpSession session=request.getSession();
		//查询数据总记录数
		int pageCounts=pageQueryService.queryCount();
		//计算总页数
		totalPages=pageCounts/pageSize==0?pageCounts/pageSize:pageCounts/pageSize+1;
	
		//把总页数放入到session中
		session.setAttribute("totalPage", totalPages);
		//把当前页放入session中
		session.setAttribute("currentPage", currentPage1);
	
		//计算分页查询的起始数
		beginIndex=(currentPage1-1)*pageSize;
		
		//封装pageQuery对象
		PageQuery pageQuery=new PageQuery();
		pageQuery.setCurrentPage(beginIndex);
		pageQuery.setTotalCount(pageCounts);
		pageQuery.setPageSize(pageSize);
		if(beginIndex==1){
			pageQuery.setFirstPage(beginIndex);
		}else {
			pageQuery.setFirstPage(firstPage);
		}
		pageQuery.setTotalPage(totalPages);
		
		List<News> pageQueryList=new ArrayList<News>();
		
		//总记录数、当前页码作为参数进行分页查询
		pageQueryList=pageQueryService.queryByLimit(pageQuery);
		
		//把查询出来的结果集放入session中
	
		session.setAttribute("pageQueryList", pageQueryList);
		
		
		
		//跳转页面
		try {
			response.sendRedirect("/GroupOrg/news.jsp");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	/**
	 * 计算下一页
	 * @param request
	 * @param response
	 */
	public void nextPage(HttpServletRequest request, HttpServletResponse response){
		
		int totalPages=0;
		int pageSize=6;
		 int beginIndex=0;
		 int currentPages=0;
		//获取页面转入的数据
		String currentPage=request.getParameter("currentPage");
		
		
		if(currentPage==null||currentPage==""){
			currentPages=1;
		}else{
			currentPages=Integer.parseInt(currentPage);
			
		}
		//创建缓存
		HttpSession session=request.getSession();
		
		//查询数据总记录数
		int pageCounts=pageQueryService.queryCount();
		//计算总页数
		totalPages=pageCounts/pageSize==0?pageCounts/pageSize:pageCounts/pageSize+1;
		
		//根据获取的currentPages当前页，计算下一页
		if(currentPages<1){
			currentPages=1;
			session.setAttribute("currentPage", currentPages);
		}else if(currentPages>=1&&currentPages<totalPages){
			currentPages=currentPages+1;
			session.setAttribute("currentPage", currentPages);
		}else if(currentPages==totalPages){
			currentPages=totalPages;
			session.setAttribute("currentPage", currentPages);
		}
		
		//根据当前页的起始记录条数，进行查询列表
		//计算分页查询的起始数
		beginIndex=(currentPages-1)*pageSize;
		
		//封装pageQuery对象
		PageQuery pageQuery=new PageQuery();
		pageQuery.setCurrentPage(beginIndex);
		pageQuery.setTotalCount(pageCounts);
		pageQuery.setPageSize(pageSize);
		if(beginIndex==1){
			pageQuery.setFirstPage(beginIndex);
		}
		pageQuery.setTotalPage(totalPages);
		
		List<News> pageQueryList=new ArrayList<News>();
		
		//总记录数、当前页码作为参数进行分页查询
		pageQueryList=pageQueryService.queryByLimit(pageQuery);
		
		//把查询出来的结果集放入session中
		session.setAttribute("pageQueryList", pageQueryList);
		System.out.println("下一页："+currentPages);
		//页面跳转
		try {
			response.sendRedirect("/GroupOrg/news.jsp");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 计算上一页
	 * @param request
	 * @param response
	 */
	public void prePage(HttpServletRequest request, HttpServletResponse response){
		
		int totalPages=0;
		int pageSize=6;
		 int beginIndex=0;
		 int currentPages=1;
		//获取页面转入的数据
		String currentPage=request.getParameter("currentPage");
		System.out.println("上一页："+currentPage);
	
		//获取当前页
		if(currentPage==null||currentPage==""){
			currentPages=1;
		}else{
			currentPages=Integer.parseInt(currentPage);
		}
		
		//创建缓存
		HttpSession session=request.getSession();
		
		//查询数据总记录数
		int pageCounts=pageQueryService.queryCount();
		//计算总页数
		totalPages=pageCounts/pageSize==0?pageCounts/pageSize:pageCounts/pageSize+1;
		
		//根据获取的currentPages当前页，计算上一页、下一页
		if(currentPages<=1){
			
			currentPages=1;
			session.setAttribute("currentPage", currentPages);
			
		}else if(currentPages>1&&currentPages<totalPages){
			
			currentPages=currentPages-1;
			session.setAttribute("currentPage", currentPages);
			
		}else if(currentPages==totalPages){
			
			currentPages=totalPages-1;
			session.setAttribute("currentPage", currentPages);
			
		}
		
		//根据当前页的起始记录条数，进行查询列表
				//计算分页查询的起始数
				beginIndex=(currentPages-1)*pageSize;
				
				//封装pageQuery对象
				PageQuery pageQuery=new PageQuery();
				pageQuery.setCurrentPage(beginIndex);
				pageQuery.setTotalCount(pageCounts);
				pageQuery.setPageSize(pageSize);
				if(beginIndex==1){
					pageQuery.setFirstPage(beginIndex);
				}
				pageQuery.setTotalPage(totalPages);
				
				List<News> pageQueryList=new ArrayList<News>();
				
				//总记录数、当前页码作为参数进行分页查询
				pageQueryList=pageQueryService.queryByLimit(pageQuery);
				
				//把查询出来的结果集放入session中
				session.setAttribute("pageQueryList", pageQueryList);
				
				//页面跳转
				try {
					response.sendRedirect("/GroupOrg/news.jsp");
				} catch (IOException e) {
			
					e.printStackTrace();
				}
	
	}
	

}
