package org.sfbtmc.activity;

import org.sfbtmc.R;
import org.sfbtmc.widget.MainPageMenuPopWindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class AgendaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda);
	}

	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.layout_title_menu_back:
				super.onBackPressed();
				break;
			case R.id.layout_title_menu_img:
				MainPageMenuPopWindow morePopWindow = new MainPageMenuPopWindow(this);
				morePopWindow.showPopupWindow(view);
				break;
		}
	}
}
