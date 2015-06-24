package org.sfbtmc.bean;

import java.io.Serializable;

import org.json.JSONObject;

import com.google.gson.annotations.SerializedName;

/**
 * refer to MainPageMsgBean.java
 *
 */
public class MainPageListBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * "id":1,"title":"Let's Go Swimming","time":"10/01/2015 10:00:00",
 * "addr":"Guess It","imgURL":"/ActivityImage/100.jpg","sponsor":0,
 * "clubNO":"CN000001","createdBy":0,"createdDate":1434970948000,"modifiedBy":0,
 * "modifiedDate":1434970948000,"status":0,"remark":null,"type":0
	 */
	
	public static final int BEAN_TYPE_ACTIVITY= 0;
	public static final int BEAN_TYPE_MEETING = 1;
	public static final int BEAN_TYPE_NOTICE = 2;
	
	
	
	@SerializedName("id")
	private String id;
	@SerializedName("title")
	private String title;
	@SerializedName("time")
	private String time;
	@SerializedName("addr")
	private String addr;
	@SerializedName("imgURL")
	private String imgRelativeUrl;
	@SerializedName("sponsor")
	private String sponsor;
	@SerializedName("clubNO")
	private String clubNo;
	@SerializedName("createBy")
	private String createBy;
	@SerializedName("createDate")
	private String createDate;
	@SerializedName("modifiedBy")
	private String modifiedBy;
	@SerializedName("modifiedDate")
	private long modifiedDate;
	@SerializedName("status")
	private int 	status;
	@SerializedName("remark")
	private String remark;
	@SerializedName("type")
	private int	type; // 0-活动, 1-会议, 2-公告
	public MainPageListBean(int beanType) {
		type  = beanType;
	}
	
	public boolean initFromJson(JSONObject jobj){
		id = jobj.optString("id");
		title = jobj.optString("title");
		time = jobj.optString("time");
		addr = jobj.optString("addr");
		imgRelativeUrl = jobj.optString("imgURL");
		sponsor = jobj.optString("sponsor");
		clubNo = jobj.optString("clubNO");
		createBy = jobj.optString("createBy");
		createDate = jobj.optString("createDate");
		modifiedBy = jobj.optString("modifiedBy");
		modifiedDate = jobj.optLong("modifiedDate");
		status = jobj.optInt("status");
		remark = jobj.optString("remark");
		type = jobj.optInt("type");
		
		return true;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getImgRelativeUrl() {
		return imgRelativeUrl;
	}
	public void setImgRelativeUrl(String imgRelativeUrl) {
		this.imgRelativeUrl = imgRelativeUrl;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getClubNo() {
		return clubNo;
	}
	public void setClubNo(String clubNo) {
		this.clubNo = clubNo;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public long getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
