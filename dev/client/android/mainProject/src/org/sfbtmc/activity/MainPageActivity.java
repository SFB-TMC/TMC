package org.sfbtmc.activity;

import org.sfbtmc.R;
import org.sfbtmc.widget.MainPageMenuPopWindow;
import org.sfbtmc.widget.MainPageMenuPopWindow.OnPopMenuClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;

public class MainPageActivity extends FragmentActivity implements
		OnClickListener,OnPopMenuClickListener {
	private static FragmentManager fMgr;
	MainPageMenuPopWindow morePopWindow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		morePopWindow = new MainPageMenuPopWindow(this);
		morePopWindow.setOnMenuClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_title_menu_img:
			morePopWindow.showPopupWindow(v);
			break;
		default:
			break;
		}
	}

	// 点击返回按钮
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	public void onClickMenu(View clickedMenu) {
		morePopWindow.dismiss();
		int viewId = clickedMenu.getId();
		if(viewId == R.id.mainpage_pop_menu_exit){
			this.finish();
			return;
		}
		if(viewId == R.id.mainpage_pop_menu_one){
			Intent in = new Intent(this,AgendaActivity.class);
			startActivity(in);
		}
		if(viewId == R.id.mainpage_pop_menu_two){
			Intent in = new Intent(this,DocDetailActivity.class);
			startActivity(in);
		}
	}
}
