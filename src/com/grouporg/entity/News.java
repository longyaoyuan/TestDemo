package com.grouporg.entity;

import java.io.Serializable;
import java.sql.Timestamp;
/*新闻类*/
public class News implements Serializable {
	private String nId;//新闻编号
	private String nTitle;//新闻标题
	private Timestamp nTime;//新闻的上传时间
	private String nContent;//新闻内容
	private String nPblush;//发布人
	private Timestamp nModifyTime;//修改时间
	
	//构造方法
	public News() {
		
	}
	public String getnId() {
		return nId;
	}
	public void setnId(String nId) {
		this.nId = nId;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public Timestamp getnTime() {
		return nTime;
	}
	public void setnTime(Timestamp nTime) {
		this.nTime = nTime;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public String getnPblush() {
		return nPblush;
	}
	public void setnPblush(String nPblush) {
		this.nPblush = nPblush;
	}
	public Timestamp getnModifyTime() {
		return nModifyTime;
	}
	public void setnModifyTime(Timestamp nModifyTime) {
		this.nModifyTime = nModifyTime;
	}
	
	
	
}
