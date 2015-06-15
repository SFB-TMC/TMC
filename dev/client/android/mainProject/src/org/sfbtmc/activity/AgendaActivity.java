package org.sfbtmc.activity;

import org.sfbtmc.R;
import org.sfbtmc.widget.AgendaMenuPopWindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AgendaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda);
//		final WebView mWebView = new WebView(this);
//		mWebView.setWebViewClient(new WebViewClient(){
//			@Override
//			public boolean shouldOverrideUrlLoading(WebView view, String url) {
//				// TODO Auto-generated method stub
//				mWebView.loadUrl("https://github.com/SFB-TMC/TMC/tree/master/doc");
//				return true;
//			}
//		});
	}

	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.layout_title_menu_back:
				super.onBackPressed();
				break;
			case R.id.layout_title_menu_img:
				AgendaMenuPopWindow morePopWindow = new AgendaMenuPopWindow(this);
				morePopWindow.showPopupWindow(view);
				break;
		}
	}
}
