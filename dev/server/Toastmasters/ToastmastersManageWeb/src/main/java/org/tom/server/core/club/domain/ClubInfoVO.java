package org.tom.server.core.club.domain;

import java.util.Date;

public class ClubInfoVO {

	/** ID **/
	private Long id;
	
	/** CLUBNO **/
	private String clubNO;
	
	/** CLUBNAME **/
	private String clubName;
	
	/** CLUBINTRO  **/
	private String clubIntro;
	
	/** FOUND_DATE **/
	private String foundDate;
	
	/** CLUBIMAGE  **/
	private byte[] clubImage;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClubNO() {
		return clubNO;
	}

	public void setClubNO(String clubNO) {
		this.clubNO = clubNO;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubIntro() {
		return clubIntro;
	}

	public void setClubIntro(String clubIntro) {
		this.clubIntro = clubIntro;
	}

	public String getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(String foundDate) {
		this.foundDate = foundDate;
	}

	public byte[] getClubImage() {
		return clubImage;
	}

	public void setClubImage(byte[] clubImage) {
		this.clubImage = clubImage;
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
}
