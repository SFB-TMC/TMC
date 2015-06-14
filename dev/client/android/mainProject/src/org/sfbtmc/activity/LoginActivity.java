package org.sfbtmc.activity;

import org.json.JSONObject;
import org.sfbtmc.R;
import org.sfbtmc.TmcManager;
import org.sfbtmc.bean.UserBean;
import org.sfbtmc.net.TmcClient;
import org.sfbtmc.net.TmcJsonHttpResponseHandler;
import org.sfbtmc.util.TmcLogUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.loopj.android.http.RequestParams;

public class LoginActivity extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_login);
	}

	private void login(){
		TmcClient client = TmcClient.getInstance();
		RequestParams param = new RequestParams();
		param.put("username", "admin");
		param.put("password", "123456");
		param.put("device", "Android");
		
		client.tmcPost("http://54.64.18.163:8080/ToastmastersServicesWeb/tmw/login", param , new TmcJsonHttpResponseHandler(){
			@Override
			public void onTmcSuccess(int statusCode, JSONObject response) {
				super.onTmcSuccess(statusCode, response);
				
				TmcLogUtils.d(response.toString());
				
				UserBean userBean = new UserBean();
				userBean.initFromJSON(response);
				
				TmcManager.getInstance().userLogined(userBean);
				TmcManager.getInstance().getUserBean().getRemark();
				
				toMainActivity();
			}
			
			@Override
			public void onTmcFailure(int statusCode, Throwable throwable,
					JSONObject errorResponse) {
				super.onTmcFailure(statusCode, throwable, errorResponse);
				
				TmcLogUtils.e(errorResponse.toString());
				
			}
		});
	}
	
	private void toMainActivity() {
		Intent in = new Intent(this, MainPageActivity.class);
		startActivity(in);

		this.finish();		
	}
	
	@Override
	public void onClick(View arg0) {
		int i = arg0.getId();
		if(R.id.activity_login_btn_login == i){
			login();
		}
	}
}
