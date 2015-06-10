package org.sfbtmc.activity;

import org.sfbtmc.R;
import org.sfbtmc.R.id;
import org.sfbtmc.R.layout;
import org.sfbtmc.widget.MainPageMenuPopWindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AgendaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda);
	}
	
	public void onClick(View view){
		switch (view.getId()) {
		case R.id.agendaMenu:
			MainPageMenuPopWindow morePopWindow = new MainPageMenuPopWindow(this);
			morePopWindow.showPopupWindow(view);
			break;

		default:
			break;
		}
	}
}
