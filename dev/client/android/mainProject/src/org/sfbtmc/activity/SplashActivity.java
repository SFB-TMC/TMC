package org.sfbtmc.activity;

import org.sfbtmc.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class SplashActivity extends FragmentActivity implements
		AnimationListener {
	private ImageView imgLogo;

	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_splash);

		imgLogo = (ImageView) findViewById(R.id.activity_splash_logo_img);
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

	private void toMainActivity() {
		Intent in = new Intent(this, MainPageActivity.class);
		startActivity(in);

		this.finish();
	}

	@Override
	public void onAnimationEnd(Animation arg0) {
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				toMainActivity();
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
}
