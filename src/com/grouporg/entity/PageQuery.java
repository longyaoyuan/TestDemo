package com.grouporg.entity;

import java.io.Serializable;

public class PageQuery implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int currentPage;//当前页
	private  int totalCount;//总记录数
	private int pageSize;//页显示记录数
	private int totalPage;//总页数
	private int  prePage;//上一页
	private int nextPage;//下一页
	private int firstPage;//首页
	
	public int getCurrentPage(){
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	/**
	 * 计算下一页
	 * @return
	 */
	public int getTotalCount() {
		return this.currentPage==this.getTotalPage()?this.getTotalPage():this.getCurrentPage()+1;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	/**
	 * 计算每页显示的记录数
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 计算总页数
	 * @return
	 */
	public int getTotalPage() {
		return this.getTotalCount()%this.getPageSize()==0?this.getTotalCount()/this.getPageSize():this.getTotalCount()/this.getPageSize()+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	/**
	 * 计算上一页
	 * @return
	 */
	public int getPrePage() {
		return this.getCurrentPage()==this.getFirstPage()?1:this.getCurrentPage()-1;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	
	
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	/**
	 * 首页，返回1
	 * @return
	 */
	public int getFirstPage() {
		return 1;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
		
}
