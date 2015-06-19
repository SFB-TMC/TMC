package org.sfbtmc.activity;

import org.sfbtmc.R;
import org.sfbtmc.util.TmcUtils;
import org.sfbtmc.widget.ActivityJoinedList;
import org.sfbtmc.widget.MainPageMenuPopWindow;
import org.sfbtmc.widget.MainPageMenuPopWindow.OnPopMenuClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ActivityActivity extends Activity implements OnPopMenuClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity);

		View v = super.findViewById(R.id.activity_joined_btn);
		v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ActivityJoinedList joined = new ActivityJoinedList(ActivityActivity.this);
				joined.showJoinedList(v);
			}
		});

		v = super.findViewById(R.id.activity_chat_button_send);
		v.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText et = (EditText) ActivityActivity.super.findViewById(R.id.activity_chat_edit_text);
				String message = et.getText().toString();
				if (TmcUtils.isNotBlank(message)) {
					TmcUtils.clearEditText(et);
					String who = "Mankel";
					ActivityActivity.this.addChatMessage(who, message, true);
					ScrollView sv = (ScrollView) ActivityActivity.super.findViewById(R.id.avtivity_chat_scroll_view);
					TmcUtils.scrollToBottom(sv);
				}
			}
		});

		this.addChatMessage("Milo", "Why is that?", false);
		this.addChatMessage("Mankel", "adsjflajiofejlajsdfiljelijailsdfjliejaliesj", true);
		this.addChatMessage("Tracy",
				"I am very happy to join this activity, too. I am very excited to see you guys. I am so proud of you all. See U then ^^", false);
		
		ScrollView sv = (ScrollView) ActivityActivity.super.findViewById(R.id.avtivity_chat_scroll_view);
		TmcUtils.scrollToBottom(sv);
	}

	private void addChatMessage(String who, String message, boolean isMyself) {
		LinearLayout v = (LinearLayout) super.findViewById(R.id.activity_chat_container);
		if (isMyself) {
			v.addView(this.getTextViewWhoSelf(who));
			v.addView(this.getTextViewMessageSelf(message));
		} else {
			v.addView(this.getTextViewWho(who));
			v.addView(this.getTextViewMessage(message));
		}
	}

	private View getTextViewWho(String who) {
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lp.setMargins(0, 0, 0, TmcUtils.dp2px(this, 2));

		TextView tv = (TextView) super.getLayoutInflater().inflate(R.layout.activity_activity_chat_who, null);
		tv.setText(who);
		tv.setLayoutParams(lp);
		return tv;
	}

	private View getTextViewMessage(String message) {
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lp.setMargins(0, 0, 0, TmcUtils.dp2px(this, 12));

		TextView tv = (TextView) super.getLayoutInflater().inflate(R.layout.activity_activity_chat_msg, null);
		tv.setText(message);
		tv.setLayoutParams(lp);
		return tv;
	}

	private View getTextViewWhoSelf(String who) {
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lp.setMargins(0, 0, 0, TmcUtils.dp2px(this, 2));
		lp.gravity = Gravity.RIGHT;

		TextView tv = (TextView) super.getLayoutInflater().inflate(R.layout.activity_activity_chat_who_self, null);
		tv.setText(who);
		tv.setLayoutParams(lp);
		return tv;
	}

	private View getTextViewMessageSelf(String message) {
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		lp.setMargins(0, 0, 0, TmcUtils.dp2px(this, 12));
		lp.gravity = Gravity.RIGHT;

		TextView tv = (TextView) super.getLayoutInflater().inflate(R.layout.activity_activity_chat_msg_self, null);
		tv.setText(message);
		tv.setLayoutParams(lp);
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
				morePopWindow.setOnMenuClickListener(this);
				break;
		}
	}

	@Override
	public void onClickMenu(View clickedMenu) {

	}

}
