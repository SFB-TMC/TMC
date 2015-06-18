package org.sfbtmc.activity;

import org.json.JSONObject;
import org.sfbtmc.R;
import org.sfbtmc.net.TmcClient;
import org.sfbtmc.net.TmcJsonHttpResponseHandler;
import org.sfbtmc.net.TmcServerConfig;
import org.sfbtmc.util.TmcLogUtils;

import com.loopj.android.http.RequestParams;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.umeng.message.PushAgent;

public class SplashActivity extends FragmentActivity implements
		AnimationListener, OnClickListener {
	private ImageView imgLogo;

	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);
		
		PushAgent mPushAgent = PushAgent.getInstance(this);
		mPushAgent.enable();
		PushAgent.getInstance(this).onAppStart();

		imgLogo = (ImageView) findViewById(R.id.activity_splash_logo_img);

		// 初始化
		TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0,
				-300.0f);
		// 设置动画时间
		translateAnimation.setDuration(1000);
//		translateAnimation.setAnimationListener(this);

		translateAnimation.setFillAfter(true);
		imgLogo.startAnimation(translateAnimation);
		// AlphaAnimation anima = new AlphaAnimation(0.3f, 1.0f);
		// anima.setDuration(3000);// 设置动画显示时间
		// imgLogo.startAnimation(anima);
		// anima.setAnimationListener(this);

		handler = new Handler();

		RequestParams params = new RequestParams();
		params.put("clientVerCode", getVersionCode());
		
		
		TmcClient tmcClient = TmcClient.getInstance();
		tmcClient
				.tmcPost(
						TmcServerConfig.NEW_VER_CHECK,
						params, new TmcJsonHttpResponseHandler() {
							/**
							 * 这个是网络发生了错误,没请求到数据的错误
							 * 
							 * @param statusCode
							 * @param throwable
							 * @param errorResponse
							 */
							public void onRequestError(int statusCode,
									Throwable throwable,
									JSONObject errorResponse) {
								TmcLogUtils.d("onRequestError");
								newVersionCheckFailed();
							}

							/**
							 * 这个是请求是成功返回的,但是服务端认为发生了错误,此时应该在 errorResponse
							 * 中去获取data的信息.
							 * 
							 * @param statusCode
							 * @param errorResponse
							 */
							public void onTmcFailure(int statusCode,
									JSONObject errorResponse) {
								TmcLogUtils.d("onTmcFailure");
								newVersionCheckFailed();
							}

							/**
							 * 当网络正常,也返回了正确的数据的回调
							 * 
							 * @param statusCode
							 * @param response
							 */
							public void onTmcSuccess(int statusCode,
									JSONObject response) {
								TmcLogUtils
										.d(" request new Version onTmcSuccess");
								int serverVersionCode = response.optInt(
										"curVersionCode", 0);
								if (serverVersionCode <= getVersionCode()) {
									toLoginActivity();
									return;
								}
								showNewVersionDialog(response);
							}
						});

	}
	private void newVersionCheckFailed(){
		toLoginActivity();
	}
	private void showNewVersionDialog(final JSONObject response){
		final int forceUpdate = response.optInt("forceUpdate");
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Update!")
		.setMessage(response.optString("curVersionDesc"))
		.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					if(1 == forceUpdate){
						cancelForceUpdate();
					}else{
						toLoginActivity();
					}
				}
			})
		.setPositiveButton("Update", new  DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				toNewVerDownloadActivity(response.optString("downUrl"));
			}
		})
		.setCancelable(false);
		
		builder.create().show();
	}
	
	private void cancelForceUpdate(){
		this.finish();
	}
	
	private void toNewVerDownloadActivity(String downloadUrl){
		NewVerDownloadActivity.startDownload(this, downloadUrl);
	}
	
	private String getVersionName() throws Exception {
		// 获取packagemanager的实例
		PackageManager packageManager = getPackageManager();
		// getPackageName()是你当前类的包名，0代表是获取版本信息
		PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(),
				0);
		String versionName = packInfo.versionName;
		
		return versionName;
	}

	private int getVersionCode() {
		// 获取packagemanager的实例
		PackageManager packageManager = getPackageManager();
		// getPackageName()是你当前类的包名，0代表是获取版本信息
		PackageInfo packInfo;
		int versionCode = 0;
		try {
			packInfo = packageManager.getPackageInfo(getPackageName(),
					0);
			versionCode = packInfo.versionCode;
			
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return versionCode;
	}
	
	
	private void toLoginActivity() {
		 Intent in = new Intent(this, LoginActivity.class);
		 startActivity(in);
		 this.finish();
	}

	@Override
	public void onAnimationEnd(Animation arg0) {
//		handler.postDelayed(new Runnable() {
//			@Override
//			public void run() {
//				toLoginActivity();
//			}
//
//		}, 500);
		// toMainActivity();
	}

	@Override
	public void onAnimationRepeat(Animation arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation arg0) {
		// TODO Auto-generated method stub

	}

	// 点击返回按钮
	@Override
	public void onBackPressed() {

	}

	@Override
	public void onClick(View arg0) {
		int viewId = arg0.getId();

	}
}
