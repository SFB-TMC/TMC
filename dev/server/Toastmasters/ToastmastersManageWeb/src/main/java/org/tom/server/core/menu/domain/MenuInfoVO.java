package org.tom.server.core.menu.domain;

import java.util.Date;

public class MenuInfoVO {

	/** ID -- 自增ID **/
	private Long id;
	
	/** MENUCODE -- 菜单编码 **/
	private String menuCode;
	
	/** MENUNAME -- 菜单名称 **/
	private String menuName;
	
	/** MENUURL -- 菜单URL **/
	private String menuURL;
	
	/** MENUCSS -- 菜单CSS **/
	private String menucss;
	
	/** MENUTITLE -- 菜单title **/
	private String menuTitle;
	
	/** MENUDESC -- 菜单描述 **/
	private String menuDesc;
	
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
