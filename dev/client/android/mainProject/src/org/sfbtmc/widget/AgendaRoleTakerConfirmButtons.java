package org.sfbtmc.widget;

import org.sfbtmc.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

public class AgendaRoleTakerConfirmButtons extends PopupWindow implements OnClickListener {

	private View conentView;
	private View row;

	public AgendaRoleTakerConfirmButtons(final Activity context, View row) {
		this.row = row;
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		conentView = inflater.inflate(R.layout.layout_agenda_confirm_buttons, null);
		// 设置SelectPicPopupWindow的View
		this.setContentView(conentView);
		// 设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(LayoutParams.WRAP_CONTENT);
		// 设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);

		// 设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		this.setOutsideTouchable(true);
		// 刷新状态
		this.update();
		// 实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0000000000);
		// 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
		this.setBackgroundDrawable(dw);
		// 设置SelectPicPopupWindow弹出窗体动画效果
		this.setAnimationStyle(R.style.AnimationPreview);

		int[] idArray = {
			R.id.agenda_role_confirm_accept,
			R.id.agenda_role_confirm_decline
		};
		for (int id : idArray) {
			this.conentView.findViewById(id).setOnClickListener(this);
		}
	}

	public void showConfirmButtons(View parent) {
		if (!this.isShowing()) {
			this.showAsDropDown(parent);
		} else {
			this.dismiss();
		}
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.agenda_role_confirm_accept) {
			this.row.setBackgroundColor(Color.parseColor("#dfffc2"));
		} else if (id == R.id.agenda_role_confirm_decline) {
			this.row.setBackgroundColor(Color.parseColor("#ffd8cf"));
		}
		this.dismiss();
	}

}