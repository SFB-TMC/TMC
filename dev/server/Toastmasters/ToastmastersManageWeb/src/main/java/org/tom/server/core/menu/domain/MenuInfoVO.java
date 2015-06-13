package org.tom.server.core.menu.domain;

import java.util.Date;

public class MenuInfoVO {

	/** ID -- ����ID **/
	private Long id;
	
	/** MENUCODE -- �˵����� **/
	private String menuCode;
	
	/** MENUNAME -- �˵����� **/
	private String menuName;
	
	/** MENUURL -- �˵�URL **/
	private String menuURL;
	
	/** MENUCSS -- �˵�CSS **/
	private String menucss;
	
	/** MENUTITLE -- �˵�title **/
	private String menuTitle;
	
	/** MENUDESC -- �˵����� **/
	private String menuDesc;
	
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

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuURL() {
		return menuURL;
	}

	public void setMenuURL(String menuURL) {
		this.menuURL = menuURL;
	}

	public String getMenucss() {
		return menucss;
	}

	public void setMenucss(String menucss) {
		this.menucss = menucss;
	}

	public String getMenuTitle() {
		return menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
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
