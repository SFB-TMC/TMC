package org.sfbtmc.bean;

import java.io.Serializable;

import org.json.JSONObject;

import com.google.gson.annotations.SerializedName;

/**
 * {"data":{"id":1,"enName":"admin","chnName":"管理员","cno":"CNO000000",
 * "age":0,"gender":0,"addr":null,"email":"yellowshuo@gmail.com","tel":"13632367100",
 * "image":null,"roleCode":"RC0000","roleName":"Super Admin","officerCode":"OC0000",
 * "officerName":"Super Officer","areaCode":"AC0000","areaName":"Super Area","clubNO":null,
 * "loginName":"admin","loginPwd":"06E5E4578560440152B587E94CDDBB41","joinDate":"06/09/2015",
 * "createdBy":0,"createdDate":1433869589000,"modifiedBy":0,"modifiedDate":1433869589000,
 * "status":0,"remark":null,"wechat":"Kail_Huang","eduTitle":"CL"},"status":0}
 *
 */
public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("id")
	private String id =null;
	@SerializedName("enName")
	private String enName = null;
	@SerializedName("chnName")
	private String chnName = null;
	@SerializedName("cno")
	private String cno = null;
	@SerializedName("age")
	private int age = 0;
	@SerializedName("gender")
	private int gender = 0;
	@SerializedName("addr")
	private String addr = null;
	@SerializedName("email")
	private String email = null;
	@SerializedName("tel")
	private String tel = null;
	@SerializedName("image")
	private String image = null;
	@SerializedName("roleCode")
	private String roleCode = null;
	@SerializedName("roleName")
	private String roleName = null;
	@SerializedName("officerCode")
	private String officerCode = null;
	@SerializedName("officerName")
	private String officerName = null;
	@SerializedName("areaCode")
	private String areaCode = null;
	@SerializedName("areaName")
	private String areaName = null;
	@SerializedName("clubNO")
	private String clubNO = null;
	@SerializedName("loginName")
	private String loginName = null;
	@SerializedName("loginPwd")
	private String loginPwd = null;
	@SerializedName("joinDate")
	private String joinDate = null;
	@SerializedName("createdBy")
	private String createdBy = null;
	@SerializedName("createdDate")
	private long createdDate = 0;
	@SerializedName("modifiedBy")
	private String modifiedBy = null;
	@SerializedName("modifiedDate")
	private long modifiedDate = 0;
	@SerializedName("status")
	private int status = 0;
	@SerializedName("remark")
	private String remark = null;
	@SerializedName("wechat")
	private String wechat = null;
	@SerializedName("eduTitle")
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
		clubNO = jobj.optString("clubNO");
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
		createdDate = jobj.optLong("createdDate");
		modifiedBy = jobj.optString("modifiedBy");
		modifiedDate = jobj.optLong("modifiedDate");
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

	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
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
	
	public String getClubNO() {
		return clubNO;
	}

	public void setClubNO(String clubNO) {
		this.clubNO = clubNO;
	}

	
}

