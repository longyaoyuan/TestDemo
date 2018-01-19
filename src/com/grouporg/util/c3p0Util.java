package com.grouporg.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * C3p0工具类
 * @author Administrator
 *
 */
public class c3p0Util {
	
	
	private static DataSource dataSource=null;
	static{
		dataSource =new ComboPooledDataSource("mysql");
		
	}
	
	/**
	 * 获取连接
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			conn=dataSource.getConnection();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭资源
	 */
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	}
}
