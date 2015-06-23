package org.sfbtmc.activity;

import org.json.JSONObject;
import org.sfbtmc.R;
import org.sfbtmc.TmcManager;
import org.sfbtmc.bean.UserBean;
import org.sfbtmc.net.TmcClient;
import org.sfbtmc.net.TmcJsonHttpResponseHandler;
import org.sfbtmc.net.TmcServerConfig;
import org.sfbtmc.util.TmcLogUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.RequestParams;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengRegistrar;

public class LoginActivity extends Activity implements OnClickListener{
	private EditText etName;
	private EditText etPass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PushAgent.getInstance(this).onAppStart();
		setContentView(R.layout.activity_login);
		
		etName = (EditText) findViewById(R.id.activity_login_username_et);
		etPass = (EditText) findViewById(R.id.activity_login_password_et);
		
	}

	private void login(){
		
		String device_token = UmengRegistrar.getRegistrationId(this);
		TmcLogUtils.e(device_token);
		
		TmcClient client = TmcClient.getInstance();
		RequestParams param = new RequestParams();
		
		param.put("username", etName.getText().toString());
		param.put("password", etPass.getText().toString());
		param.put("device", "Android");
		
		client.tmcPost(TmcServerConfig.BASE_URL + "tmw/login", param , new TmcJsonHttpResponseHandler(){
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
			public void onTmcFailure(int statusCode,
					JSONObject errorResponse) {
				super.onTmcFailure(statusCode, errorResponse);
				if(null == errorResponse){
					return;
				}
				TmcLogUtils.e(errorResponse.toString());
				Toast.makeText(getApplicationContext(), "Login in failed:" + errorResponse.optString("data"),Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void onRequestError(int statusCode, Throwable throwable,
					JSONObject errorResponse) {
				super.onRequestError(statusCode, throwable, errorResponse);
				
				Toast.makeText(getApplicationContext(), "Network error",Toast.LENGTH_SHORT).show();
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
		if(R.id.activity_login_btn_login_skip == i){
			toMainActivity();
		}
	}
}
