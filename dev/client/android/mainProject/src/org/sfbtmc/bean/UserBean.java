package org.sfbtmc.bean;

import java.io.Serializable;

import org.json.JSONObject;

public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String remark = null;
	private String modifiedBy = null;
	private String tel = null;
	private String roleName = null;
	private String addr = null;
	private String officerName = null;
	private String joinDate = null;
	
	
	
	private String loginName = null;
	private int status = 0;
	
	private String email = null;
	

	public boolean initFromJSON(JSONObject jobj){
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
