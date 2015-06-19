package org.sfbtmc.util;

import org.apache.commons.lang.StringUtils;

import android.content.Context;
import android.os.Handler;
import android.widget.EditText;
import android.widget.ScrollView;

public class TmcUtils extends StringUtils {

	/**
	 * Turn dp to px.
	 */
	public static int dp2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * Turn px to dp.
	 */
	public static int px2dp(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public static void clearEditText(EditText et) {
		if (null != et) {
			et.setText(TmcConstants.EMPTY_STRING);
		}
	}

	public static void scrollToBottom(final ScrollView sv) {
		Handler handler = new Handler();
		handler.post(new Runnable() {
			@Override
			public void run() {
				sv.fullScroll(ScrollView.FOCUS_DOWN);
			}
		});
	}

}
