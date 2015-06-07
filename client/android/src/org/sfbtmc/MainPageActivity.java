package org.sfbtmc;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class MainPageActivity extends FragmentActivity {
	private static FragmentManager fMgr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		
		
	}

	//点击返回按钮
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}
}
