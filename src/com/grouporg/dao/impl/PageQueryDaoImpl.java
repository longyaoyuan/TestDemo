package com.grouporg.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grouporg.dao.PageQueryDao;
import com.grouporg.entity.News;
import com.grouporg.entity.PageQuery;
import com.grouporg.util.JdbcUtil;

public class PageQueryDaoImpl implements PageQueryDao {
	private Connection conn=null;
	private PreparedStatement pstm=null;
	private ResultSet rs=null;
	private int rows=0;
	/**
	 * 查询总的记录数
	 */
	public int queryCount() {
		try {
			conn=JdbcUtil.getConn();
			String sql="select count(*) from news";
		
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return rows;
	}

	/**
	 * 分页查询
	 */
	public List<News> queryByLimit(PageQuery pageQuery) {
		List<News> newsList=new ArrayList<News>();
		News news=null;
		try {
			conn=JdbcUtil.getConn();
			String sql="select * from news limit ?,?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, pageQuery.getCurrentPage());
			pstm.setInt(2, pageQuery.getPageSize());
			rs=pstm.executeQuery();
			while(rs.next()){
				news=new News();
				news.setnId(rs.getString("nId"));
				news.setnTitle(rs.getString("nTitle"));
				news.setnTime(rs.getTimestamp("nTime"));
				news.setnContent(rs.getString("nContent"));
				news.setnPblush(rs.getString("nPblush"));
				news.setnModifyTime(rs.getTimestamp("nModifyTime"));
				newsList.add(news);
		
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			//JdbcUtil.closeAll(conn, pstm, rs);
		}
		
		return newsList;
	
	}

}
