package com.grouporg.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.grouporg.dao.NewsDao;
import com.grouporg.entity.News;
import com.grouporg.entity.PageQuery;
import com.grouporg.util.JdbcUtil;

public class NewsDaoImpl implements NewsDao{
		private Connection conn=null;
		private PreparedStatement pstm=null;
		private ResultSet rs=null;
		private int rows=0;
		//增加新闻
	public void addNews(News news){
		
		try {
			conn=JdbcUtil.getConn();
			String sql="insert into news(nId,nTitle,nTime,nContent,nPblush,nModifyTime) values(?,?,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, news.getnId());
			pstm.setString(2, news.getnTitle());
			pstm.setTimestamp(3, news.getnTime());
			pstm.setString(4,news.getnContent());
			pstm.setString(5, news.getnPblush());
			pstm.setTimestamp(6, news.getnModifyTime());
			rows=pstm.executeUpdate();
			if(rows>0){
				System.out.println("数据添加成功！");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(conn, pstm, rs);
		}
		
	}
		//根据新闻id修改新闻
	public void updateNewsById(News news) {

		try {
			conn=JdbcUtil.getConn();
			String sql="update news set nTitle=?,nContent=?,nPblush=? where nId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, news.getnTitle());
			pstm.setString(2,news.getnContent());
			pstm.setString(3, news.getnPblush());
			pstm.setString(4, news.getnId());
			rows=pstm.executeUpdate();
			if(rows>0){
				System.out.println("数据修改成功！");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(conn, pstm, rs);
		}
		
	}
		
		
	

	//删除新闻根据新闻id
	public void delNewsById(News news) {
		
		try {
			conn=JdbcUtil.getConn();
			String sql="delete from news where nId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, news.getnId());
			rows=pstm.executeUpdate();
			if(rows>0){
				System.out.println("数据删除成功！");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(conn, pstm, rs);
		}
		
		
	}

	//查询新闻列表
	public List<News> queryNewsList() {
		List<News> newsList=new ArrayList<News>();
		News news=null;
		try {
			conn=JdbcUtil.getConn();
			String sql="select * from news";
			pstm=conn.prepareStatement(sql);
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
			JdbcUtil.closeAll(conn, pstm, rs);
		}
		
		return newsList;
	}


	//查询新闻根据新闻标题
	public News queryNewsByTitle(News news) {
			News news2=null;
		try {
			conn=JdbcUtil.getConn();
			String sql="select * from news where nTitle like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+news.getnTitle()+"%");
			rs=pstm.executeQuery();
			if(rs.next()){
				news2=new News();
				news2.setnId(rs.getString("nId"));
				news2.setnTitle(rs.getString("nTitle"));
				news2.setnTime(rs.getTimestamp("nTime"));
				news2.setnContent(rs.getString("nContent"));
				news2.setnPblush(rs.getString("nPblush"));
				news2.setnModifyTime(rs.getTimestamp("nModifyTime"));
			}
			
		} catch (Exception e) {	
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(conn, pstm, rs);
		}
		
	
		return news2;
	}
	
	/**
	 * 分页查询
	 */
	public List<News> queryListByLimit(PageQuery pageQuery) {
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
			JdbcUtil.closeAll(conn, pstm, rs);
		}
		
		return newsList;
	
	}
	/**
	 * 根据 新闻id新查询
	 */
	public News queryNewsById(String id) {
			News news=null;
			
		try {
			conn=JdbcUtil.getConn();
			String sql="select * from news where nId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,id);
			rs=pstm.executeQuery();
			if(rs.next()){
				news=new News();
				news.setnId(rs.getString("nId"));
				news.setnTitle(rs.getString("nTitle"));
				news.setnTime(rs.getTimestamp("nTime"));
				news.setnContent(rs.getString("nContent"));
				news.setnPblush(rs.getString("nPblush"));
				news.setnModifyTime(rs.getTimestamp("nModifyTime"));
			}
		} catch (Exception e) {
				
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(conn, pstm, rs);
		}
		
		return news;
	}
	/**
	 * 查询总的记录数
	 */
	public int queryNewsCount() {
		int count=0;
		try {
			conn=JdbcUtil.getConn();
			String sql="select COUNT(*) from news";
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			
			
			}
			
		} catch (Exception e) {	
			e.printStackTrace();
		}finally{
			JdbcUtil.closeAll(conn, pstm, rs);
		}
		
	
		return count;
		
	}

}
