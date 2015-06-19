package org.sfbtmc.bean;

import java.io.Serializable;

import org.json.JSONObject;

public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id =null;
	private String enName = null;
	private String chnName = null;
	private String cno = null;
	private int age = 0;
	private int gender = 0;
	private String addr = null;
	private String email = null;
	private String tel = null;
	private String image = null;
	private String roleCode = null;
	private String roleName = null;
	private String officerCode = null;
	private String officerName = null;
	private String areaCode = null;
	private String areaName = null;
	private String loginName = null;
	private String loginPwd = null;
	private String joinDate = null;
	private String createdBy = null;
	private String createdDate = null;
	private String modifiedBy = null;
	private String modifiedDate = null;
	private int status = 0;
	private String remark = null;
	private String wechat = null;
	private String eduTitle = null;
	
	/**
	 * next i will use gson lib
	 * @param jobj
	 * @return
	 */
	
	public boolean initFromJSON(JSONObject jobj){
		
		id = jobj.optString("id");
		enName = jobj.optString("enName");
		chnName = jobj.optString("chnName");
		cno = jobj.optString("cno");
		age = jobj.optInt("age");
		gender = jobj.optInt("gender");
		addr = jobj.optString("addr");
		email = jobj.optString("email");
		tel = jobj.optString("tel");
		image = jobj.optString("image");
		roleCode = jobj.optString("roleCode");
		roleName = jobj.optString("roleName");
		officerCode = jobj.optString("officerCode");
		officerName = jobj.optString("officerName");
		areaCode = jobj.optString("areaCode");
		areaName = jobj.optString("areaName");
		loginName = jobj.optString("loginName");
		loginPwd = jobj.optString("loginPwd");
		joinDate = jobj.optString("joinDate");
		createdBy = jobj.optString("createdBy");
		createdDate = jobj.optString("createdDate");
		modifiedBy = jobj.optString("modifiedBy");
		modifiedDate = jobj.optString("modifiedDate");
		status = jobj.optInt("status");
		remark = jobj.optString("remark");
		wechat = jobj.optString("wechat");
		eduTitle = jobj.optString("eduTitle");
	
	 return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getChnName() {
		return chnName;
	}

	public void setChnName(String chnName) {
		this.chnName = chnName;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOfficerCode() {
		return officerCode;
	}

	public void setOfficerCode(String officerCode) {
		this.officerCode = officerCode;
	}

	public String getOfficerName() {
		return officerName;
	}

	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
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

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getEduTitle() {
		return eduTitle;
	}

	public void setEduTitle(String eduTitle) {
		this.eduTitle = eduTitle;
	}
	
	
}

