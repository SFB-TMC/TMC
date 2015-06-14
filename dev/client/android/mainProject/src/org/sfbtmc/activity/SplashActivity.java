package org.sfbtmc.activity;

import org.json.JSONObject;
import org.sfbtmc.R;
import org.sfbtmc.net.TmcClient;
import org.sfbtmc.net.TmcJsonHttpResponseHandler;
import org.sfbtmc.util.TmcLogUtils;

import com.loopj.android.http.RequestParams;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class SplashActivity extends FragmentActivity implements
		AnimationListener,OnClickListener {
	private ImageView imgLogo;

	private Handler handler;
	
	private Button btnTest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);

		imgLogo = (ImageView) findViewById(R.id.activity_splash_logo_img);
		btnTest = (Button) findViewById(R.id.btn_test);
		btnTest.setOnClickListener(this);
		
		// 初始化
		 TranslateAnimation translateAnimation = new TranslateAnimation(0, 0,
		 0,-300.0f);
		 //设置动画时间
		 translateAnimation.setDuration(1000);
		 translateAnimation.setAnimationListener(this);
		 
		 translateAnimation.setFillAfter(true);
		 imgLogo.startAnimation(translateAnimation);
//		AlphaAnimation anima = new AlphaAnimation(0.3f, 1.0f);
//		anima.setDuration(3000);// 设置动画显示时间
//		imgLogo.startAnimation(anima);
//		anima.setAnimationListener(this);

		handler = new Handler();
		
		
		
	}

	private void toLoginActivity() {
		Intent in = new Intent(this, LoginActivity.class);
		startActivity(in);
		this.finish();
	}

	@Override
	public void onAnimationEnd(Animation arg0) {
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				toLoginActivity();
			}

		}, 500);
//		toMainActivity();
	}

	@Override
	public void onAnimationRepeat(Animation arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation arg0) {
		// TODO Auto-generated method stub

	}

//	 点击返回按钮
	 @Override
	 public void onBackPressed() {
	
	 }

	@Override
	public void onClick(View arg0) {
		int viewId = arg0.getId();
		if(viewId == R.id.btn_test){
		}
		
		
	}
}
