package com.grouporg.entity;

import java.io.Serializable;
/*图片类*/
public class GroupImg implements Serializable {
	private String iId ;//图片编码
	private String iName;//图片名称 
	private  String iUrl;//图片的保存路径
	
	
	//构造方法
	public GroupImg() {
		
	}
	public String getiId() {
		return iId;
	}
	public void setiId(String iId) {
		this.iId = iId;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public String getiUrl() {
		return iUrl;
	}
	public void setiUrl(String iUrl) {
		this.iUrl = iUrl;
	}
	
	
}
