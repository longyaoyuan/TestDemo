package com.grouporg.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class JdbcUtil {
	static Connection conn=null;
	static PreparedStatement pstm=null;
	static ResultSet rs=null;
	static int rows=0;
	
	public  static Connection getConn(){
		try {
				if(conn==null){
					conn=c3p0Util.getConnection();	
			}
				} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		return conn;
	}
	
	public static void closeAll(Connection conn,PreparedStatement pstm,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		if(pstm!=null){
			try {
				pstm.close();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}
	
}
