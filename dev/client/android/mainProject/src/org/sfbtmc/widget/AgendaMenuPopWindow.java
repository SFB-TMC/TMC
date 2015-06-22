package org.sfbtmc.widget;

import org.sfbtmc.R;
import org.sfbtmc.util.TmcLogUtils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

public class AgendaMenuPopWindow extends PopupWindow implements OnClickListener {
	private View conentView;
	private OnPopMenuClickListener onMenuClickListener;

	public AgendaMenuPopWindow(final Activity context) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		conentView = inflater.inflate(R.layout.agenda_popupwindow, null);
		int h = context.getWindowManager().getDefaultDisplay().getHeight();
		int w = context.getWindowManager().getDefaultDisplay().getWidth();
		// 设置SelectPicPopupWindow的View
		this.setContentView(conentView);
		// 设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(w / 2 + 50);
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
		// mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
		// 设置SelectPicPopupWindow弹出窗体动画效果
//		this.setAnimationStyle(R.style.AnimationPreview);

		int[] idArray = {
				R.id.agenda_pop_menu_historyagenda,
				R.id.agenda_pop_menu_manageagenda,
				R.id.agenda_pop_menu_assignrole,
				R.id.agenda_pop_menu_menu_1,
				R.id.agenda_pop_menu_menu_2,
				R.id.agenda_pop_menu_menu_3,
				R.id.agenda_pop_menu_exit
		};
		for (int id : idArray) {
			conentView.findViewById(id).setOnClickListener(this);
		}
	}

	public void showPopupWindow(View parent) {
		if (!this.isShowing()) {
			//this.showAsDropDown(parent);
			this.showAsDropDown(parent,-50,-10);
		} else {
			this.dismiss();
		}
	}

	public OnPopMenuClickListener getOnMenuClickListener() {
		return onMenuClickListener;
	}

	public void setOnMenuClickListener(OnPopMenuClickListener onMenuClickListener) {
		this.onMenuClickListener = onMenuClickListener;
	}

	public interface OnPopMenuClickListener {
		public void onClickMenu(View clickedMenu);

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.agenda_pop_menu_exit:
			TmcLogUtils.d("点击退出菜单");
			break;
		case R.id.agenda_pop_menu_historyagenda:
			TmcLogUtils.d("点击查看历史agenda菜单");
			break;
		case R.id.agenda_pop_menu_manageagenda:
			TmcLogUtils.d("点击管理agenda菜单");
			break;
		case R.id.agenda_pop_menu_assignrole:
			TmcLogUtils.d("点击分配角色菜单");
			break;
		default:
			break;
		}
		if (null == onMenuClickListener) {
			return;
		}
		onMenuClickListener.onClickMenu(arg0);
	}
}