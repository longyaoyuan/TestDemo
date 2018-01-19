package com.grouporg.dao;

import java.util.List;

import com.grouporg.entity.News;
import com.grouporg.entity.PageQuery;

/**
 * 分页查询接口
 * @author Administrator
 *
 */
public interface PageQueryDao {
	//查询总记录数
	public int queryCount();
	
	//分页查询
	public List<News> queryByLimit(PageQuery pageQuery);
}
