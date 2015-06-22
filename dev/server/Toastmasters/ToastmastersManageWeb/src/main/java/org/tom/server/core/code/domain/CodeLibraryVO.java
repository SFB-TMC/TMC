package org.tom.server.core.code.domain;

import java.util.Date;

public class CodeLibraryVO {

	/** ID -- 自增ID **/
	private Long id;
	
	/** CODENO -- 类型编码 **/
	private String codeNO;
	
	/** ITEMNO -- 子项编码 **/
	private String itemNO;
	
	/** ITEMNAME -- 子项名称 **/
	private String itemName;
	
	/** CREATED_BY -- 创建记录人 **/
	private Long createdBy;
	
	/** CREATED_DATE -- 创建记录时间 **/
	private Date createdDate;
	
	/** MODIFIED_BY -- 修改记录人 **/
	private Long modifiedBy;
	
	/** MODIFIED_DATE -- 修改记录时间 **/
	private Date modifiedDate;
	
	/** STATUS -- 状态 0-正常（默认值）-1-禁用 **/
	private int status;
	
	/** REMARK -- 备注 **/
	private String remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeNO() {
		return codeNO;
	}

	public void setCodeNO(String codeNO) {
		this.codeNO = codeNO;
	}

	public String getItemNO() {
		return itemNO;
	}

	public void setItemNO(String itemNO) {
		this.itemNO = itemNO;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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
