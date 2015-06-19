package org.sfbtmc.activity;

import org.sfbtmc.R;
import org.sfbtmc.widget.MainPageMenuPopWindow;
import org.sfbtmc.widget.MainPageMenuPopWindow.OnPopMenuClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;

public class MainPageActivity extends FragmentActivity implements OnClickListener, OnPopMenuClickListener {

	private MainPageMenuPopWindow morePopWindow;

	private final static SparseArray<Class<?>> MENU_ID = new SparseArray<Class<?>>(0);
	static {
		MENU_ID.put(R.id.mainpage_pop_menu_notification, NotificationActivity.class);
		// MENU_ID.put(R.id.mainpage_pop_menu_special_column, null);
		MENU_ID.put(R.id.mainpage_pop_menu_agenda, AgendaActivity.class);
		MENU_ID.put(R.id.mainpage_pop_menu_doc, DocDetailActivity.class);
		 MENU_ID.put(R.id.mainpage_pop_menu_activity, ActivityActivity.class);
		// MENU_ID.put(R.id.mainpage_pop_menu_3, .class);
		// MENU_ID.put(R.id.mainpage_pop_menu_exit, null);
	}

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
		Class<?> clazz = MENU_ID.get(clickedMenu.getId());
		if (null != clazz) {
			morePopWindow.dismiss();
			startActivity(new Intent(this, clazz));
		} else if (clickedMenu.getId() == R.id.mainpage_pop_menu_exit) {
			this.finish();
		}
	}
}
