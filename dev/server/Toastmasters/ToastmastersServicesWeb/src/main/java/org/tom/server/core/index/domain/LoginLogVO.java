package org.tom.server.core.index.domain;

import java.util.Date;

public class LoginLogVO {

	/** ID -- Login ID **/
	private Long id;
	
	/** LOGIN_IP -- Login IP **/
	private String loginIp;
	
	/** LOGIN_TIME -- Login Time **/
	private Date loginTime;
	
	/** LOGIN_NAME -- Login Name **/
	private String loginName;
	
	/** DEVICE -- device **/
	private String device;
	
	/** STATUS -- 0-common 1-forbidden **/
	private int status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
