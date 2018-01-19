package com.grouporg.service.impl;

import java.util.List;

import com.grouporg.dao.PageQueryDao;
import com.grouporg.dao.impl.PageQueryDaoImpl;
import com.grouporg.entity.News;
import com.grouporg.entity.PageQuery;
import com.grouporg.service.PageQueryService;

public class PageQueryServiceImpl implements PageQueryService {
		PageQueryDao pageQueryDao=new PageQueryDaoImpl();
	/**
	 * 查询总记录数
	 */
	public int queryCount() {
		
		return pageQueryDao.queryCount();
	}

	/**
	 * 分页查询
	 */
	public List<News> queryByLimit(PageQuery pageQuery) {
		
		return pageQueryDao.queryByLimit(pageQuery);
	}

}
