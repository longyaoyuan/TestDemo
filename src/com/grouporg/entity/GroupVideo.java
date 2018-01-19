package com.grouporg.entity;

import java.io.Serializable;
	/*视频类*/
public class GroupVideo implements Serializable {
	private String vId;//视频编号
	private String vName;//视频名称
	private String vUrl;//视频路径
	
	
	//构造方法
	public GroupVideo() {
		
	}
	public String getvId() {
		return vId;
	}
	public void setvId(String vId) {
		this.vId = vId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getvUrl() {
		return vUrl;
	}
	public void setvUrl(String vUrl) {
		this.vUrl = vUrl;
	}
	
	
}
