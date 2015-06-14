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
	
	public boolean initFromJSON(JSONObject jobj){
		id = jobj.optString("id");
		enName = jobj.optString("enName");
		chnName = jobj.optString("chnName");
		cno = jobj.optString("cno");
		age = jobj.optInt("age");
		gender = jobj.optInt("gender");
		addr = jobj.optString("addr");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		id = jobj.optString("id");
		
		remark = jobj.optString("response");
		modifiedBy = jobj.optString("modifiedBy");
		tel = jobj.optString("tel");
		roleName = jobj.optString("roleName");
		addr = jobj.optString("addr");
		officerName = jobj.optString("officerName");
		joinDate = jobj.optString("joinDate");
	 
	 
	 
	 
	 return true;
	}
	
	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}
}

