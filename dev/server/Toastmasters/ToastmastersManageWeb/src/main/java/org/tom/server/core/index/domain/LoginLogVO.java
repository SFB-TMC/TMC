package org.tom.server.core.index.domain;

import java.util.Date;

public class LoginLogVO {

	/** ID -- 自增ID **/
	private Long id;
	
	/** LOGIN_IP -- 登录IP **/
	private String loginIp;
	
	/** LOGIN_TIME -- 登录时间 **/
	private Date loginTime;
	
	/** LOGIN_NAME -- 登录名称 **/
	private String loginName;
	
	/** DEVICE -- 设备名称 **/
	private String device;
	
	/** STATUS -- 状态：0-成功；-1-失败 **/
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
