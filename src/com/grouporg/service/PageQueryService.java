package com.grouporg.service;

import java.util.List;

import com.grouporg.entity.News;
import com.grouporg.entity.PageQuery;

public interface PageQueryService {
	//查询总记录数
		public int queryCount();
		
		//分页查询
		public List<News> queryByLimit(PageQuery pageQuery);
}
