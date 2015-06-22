package org.tom.server.core.user.domain;

import java.util.Date;

/**
 * User Information
 * @author yellowshuo
 */
public class UserInfoVO {

	/** ID -- ID **/
	private Long id;
	
	/** ENNAME -- English Name **/
	private String enName;
	
	/** CHNNAME -- Chinese Name **/
	private String chnName;
	
	/** CNO -- User NO **/
	private String cno;
	
	/** AGE -- Age **/
	private int age;
	
	/** GENDER -- gender 0-male��1-female **/
	private int gender;
	
	/** ADDR -- address **/
	private String addr;
	
	/** EMAIL -- email **/
	private String email;
	
	/** TEL -- telphone **/
	private String tel;
	
	/** IMAGE -- user image **/
	private byte[] image;
	
	/** ROLE_CODE -- role code **/
	private String roleCode;
	
	/** ROLE_NAME -- role name **/
	private String roleName;
	
	/** OFFICER_CODE -- officer code **/
	private String officerCode;
	
	/** OFFICER_NAME -- officer name **/
	private String officerName;
	
	/** AREA_CODE -- area code **/
	private String areaCode;
	
	/** AREA_NAME -- area name **/
	private String areaName;
	
	/** CLUBNO **/
	private String clubNO;
	
	/** LOGIN_NAME -- login name **/
	private String loginName;
	
	/** LOGIN_PWD -- login password **/
	private String loginPwd;
	
	/** JOIN_DATE -- join date **/
	private String joinDate;
	
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

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
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

	public String getClubNO() {
		return clubNO;
	}

	public void setClubNO(String clubNO) {
		this.clubNO = clubNO;
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
