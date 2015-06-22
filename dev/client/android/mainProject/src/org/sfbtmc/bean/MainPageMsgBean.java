package org.sfbtmc.bean;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.annotations.SerializedName;

/**
 * {"list":[{"id":1,"title":"Let's Go Swimming","time":"10/01/2015 10:00:00",
 * "addr":"Guess It","imgURL":"/ActivityImage/100.jpg","sponsor":0,
 * "clubNO":"CN000001","createdBy":0,"createdDate":1434970948000,"modifiedBy":0,
 * "modifiedDate":1434970948000,"status":0,"remark":null,"type":0},
 * {"id":2,"title":"Let's Go Hiding","time":"10/01/2015 10:00:00","addr":"Guess It",
 * "imgURL":"/ActivityImage/100.jpg","sponsor":0,"clubNO":"CN000001","createdBy":0,
 * "createdDate":1434971094000,"modifiedBy":0,"modifiedDate":1434971094000,"status":0,
 * "remark":null,"type":0},{"id":3,"title":"Let's Go Sleeping","time":"10/01/2015 10:00:00",
 * "addr":"Guess It","imgURL":"/ActivityImage/100.jpg","sponsor":0,"clubNO":"CN000001",
 * "createdBy":0,"createdDate":1434971094000,"modifiedBy":0,"modifiedDate":1434971094000,
 * "status":0,"remark":null,"type":0}],
 * "url":"http://localhost:8080/ToastmasterFileServer/"}
 *
 */
public class MainPageMsgBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("url")
	private String imgUrlHost;
	
	
	@SerializedName("list")
	private ArrayList<MainPageListBean> msgBeanList = new ArrayList<MainPageListBean>();

	
	public MainPageMsgBean(){
		msgBeanList.add(new MainPageListBean(MainPageListBean.BEAN_TYPE_ACTIVITY));
		msgBeanList.add(new MainPageListBean(MainPageListBean.BEAN_TYPE_MEETING));
		msgBeanList.add(new MainPageListBean(MainPageListBean.BEAN_TYPE_NOTICE));
		msgBeanList.add(new MainPageListBean(MainPageListBean.BEAN_TYPE_ACTIVITY));
		msgBeanList.add(new MainPageListBean(MainPageListBean.BEAN_TYPE_MEETING));
		msgBeanList.add(new MainPageListBean(MainPageListBean.BEAN_TYPE_NOTICE));
		
	}
	
	public boolean initFromJson(JSONObject jobj){
		imgUrlHost = jobj.optString("url");
		
		msgBeanList.clear();
		JSONArray jarr = jobj.optJSONArray("list");
		
		for(int i=0; i<jarr.length(); i++){
			MainPageListBean listBean = new MainPageListBean(MainPageListBean.BEAN_TYPE_ACTIVITY);
			listBean.initFromJson(jarr.optJSONObject(i));
			msgBeanList.add(listBean);
		}
		
		return true;
	}
	
	public boolean addMsgBeanList(JSONArray jarr){
		for(int i=0; i<jarr.length(); i++){
			MainPageListBean listBean = new MainPageListBean(MainPageListBean.BEAN_TYPE_MEETING);
			listBean.initFromJson(jarr.optJSONObject(i));
			msgBeanList.add(listBean);
		}
		
		return true;
	}
	
	public String getImgUrlHost() {
		return imgUrlHost;
	}

	public void setImgUrlHost(String imgUrlHost) {
		this.imgUrlHost = imgUrlHost;
	}

	public ArrayList<MainPageListBean> getMsgBeanList() {
		return msgBeanList;
	}

//	public void setMsgBeanList(ArrayList<MainPageListBean> msgBeanList) {
//		this.msgBeanList = msgBeanList;
//	}
//	
	
	
	
}
