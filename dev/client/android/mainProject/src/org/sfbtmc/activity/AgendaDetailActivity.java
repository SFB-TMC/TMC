package org.sfbtmc.activity;

import java.util.ArrayList;
import java.util.List;

import org.sfbtmc.R;
import org.sfbtmc.widget.AgendaRoleTakerConfirmButtons;
import org.sfbtmc.widget.MainPageMenuPopWindow;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AgendaDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda_detail);

		this.highlight();
	}

	private void highlight() {
		LinearLayout linearLayout = (LinearLayout) super.findViewById(R.id.meeting_agenda_page_item_container);
		int count = linearLayout.getChildCount();
		String color = null;
		List<TableLayout> list = new ArrayList<TableLayout>(0);
		for (int i = 0; i < count; i++) {
			View v = linearLayout.getChildAt(i);
			if (v instanceof TableLayout) {
				list.add((TableLayout) v);
			}
		}
		for (int j = 0; j < list.size(); j++) {
			final TableLayout tableLayout = list.get(j);
			if (2 == j) {
				// yellow: need to be confirmed
				color = "#f6fe9b";
			} else {
				color = null;
			}
			if (null != color) {
				tableLayout.setBackgroundColor(Color.parseColor(color));
				this.getRoleTakerView(tableLayout).setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						new AgendaRoleTakerConfirmButtons(AgendaDetailActivity.this, tableLayout).showConfirmButtons(v);
					}
				});
			}
		}
	}

	private View getRoleTakerView(TableLayout tableLayout) {
		TableRow r = (TableRow) tableLayout.getChildAt(0);
		TextView tv = (TextView) r.getChildAt(r.getChildCount() - 1);
		return tv;
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
