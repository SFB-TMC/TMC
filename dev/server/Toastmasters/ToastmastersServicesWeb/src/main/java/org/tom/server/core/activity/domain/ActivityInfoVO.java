package org.tom.server.core.activity.domain;

import java.util.Date;

public class ActivityInfoVO {

	/** ID **/
	private Long id;
	
	/** TITLE **/
	private String title;
	
	/** TIME **/
	private String time;
	
	/** ADDR **/
	private String addr;
	
	/** IMG_URL **/
	private String imgURL;
	
	/** SPONSOR **/
	private Long sponsor;
	
	/** CLUB NO **/
	private String clubNO;
	
	/** CREATED_BY -- created by **/
	private Long createdBy;
	
	/** CREATED_DATE -- created date **/
	private Date createdDate;
	
	/** MODIFIED_BY -- modified by **/
	private Long modifiedBy;
	
	/** MODIFIED_DATE -- modified date **/
	private Date modifiedDate;
	
	/** STATUS -- status 0-normal -1-banned **/
	private int status;
	
	/** REMARK -- remark **/
	private String remark;
	
	/** Recommand Type: 0-Activity; 1-Meeting; 2-Notice **/
	private int type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public Long getSponsor() {
		return sponsor;
	}

	public void setSponsor(Long sponsor) {
		this.sponsor = sponsor;
	}

	public String getClubNO() {
		return clubNO;
	}

	public void setClubNO(String clubNO) {
		this.clubNO = clubNO;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
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
