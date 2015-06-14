package org.sfbtmc.activity;

import org.sfbtmc.R;
import org.sfbtmc.widget.MainPageMenuPopWindow;
import org.sfbtmc.widget.MainPageMenuPopWindow.OnPopMenuClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class NotificationActivity extends Activity implements OnPopMenuClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
	}

	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.layout_title_menu_back:
				super.onBackPressed();
				break;
			case R.id.layout_title_menu_img:
				MainPageMenuPopWindow morePopWindow = new MainPageMenuPopWindow(this);
				morePopWindow.showPopupWindow(view);
				morePopWindow.setOnMenuClickListener(this);
				break;
		}
	}

	@Override
	public void onClickMenu(View clickedMenu) {
		
	}

}
