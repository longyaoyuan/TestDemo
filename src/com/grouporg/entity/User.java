package com.grouporg.entity;

import java.io.Serializable;
/*管理员用户类*/
public class User implements Serializable {
	private String uId;//用户编号 
	private  String uName;//用户名
	private String uPwd;//密码 
	private String uPhone;//用户电话
	
	
	//构造方法
	public User() {
		
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	
	
}
