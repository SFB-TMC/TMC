package org.sfbtmc;

import org.sfbtmc.bean.UserBean;

public class TmcManager {
	private static TmcManager instance;
	
	private UserBean userBean;

	private TmcManager(){
		
	}
	
	public static TmcManager getInstance(){
		if(null == instance){
			instance = new TmcManager();
		}
		return instance;
	}

	public void userLogined(UserBean bean){
		this.userBean = bean;
	}
	public UserBean getUserBean(){
		return userBean; 
	}
	
}
