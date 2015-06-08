package org.sfbtmc.activity;

import org.sfbtmc.R;
import org.sfbtmc.R.id;
import org.sfbtmc.R.layout;
import org.sfbtmc.widget.MainPageMenuPopWindow;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupMenu;

public class MainPageActivity extends FragmentActivity implements
		OnClickListener {
	private static FragmentManager fMgr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_title_menu_img:
			MainPageMenuPopWindow morePopWindow = new MainPageMenuPopWindow(this);
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
}
