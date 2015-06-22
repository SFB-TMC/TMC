package org.tom.server.core.code.domain;

import java.util.Date;

public class CodeLibraryVO {

	/** ID -- ����ID **/
	private Long id;
	
	/** CODENO -- ���ͱ��� **/
	private String codeNO;
	
	/** ITEMNO -- ������� **/
	private String itemNO;
	
	/** ITEMNAME -- �������� **/
	private String itemName;
	
	/** CREATED_BY -- ������¼�� **/
	private Long createdBy;
	
	/** CREATED_DATE -- ������¼ʱ�� **/
	private Date createdDate;
	
	/** MODIFIED_BY -- �޸ļ�¼�� **/
	private Long modifiedBy;
	
	/** MODIFIED_DATE -- �޸ļ�¼ʱ�� **/
	private Date modifiedDate;
	
	/** STATUS -- ״̬ 0-������Ĭ��ֵ��-1-���� **/
	private int status;
	
	/** REMARK -- ��ע **/
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
