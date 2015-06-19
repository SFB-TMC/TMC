package org.sfbtmc.activity;

import org.sfbtmc.R;
import org.sfbtmc.R.id;
import org.sfbtmc.R.layout;
import org.sfbtmc.fragment.AddressFragment;
import org.sfbtmc.fragment.FindFragment;
import org.sfbtmc.fragment.MeFragment;
import org.sfbtmc.fragment.WeiXinFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends FragmentActivity {
	private static FragmentManager fMgr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fMgr = getSupportFragmentManager();
		
		initFragment();
		dealBottomButtonsClickEvent();
	}

	/**
	 * 初始化首个Fragment
	 */
	private void initFragment() {
		FragmentTransaction ft = fMgr.beginTransaction();
		WeiXinFragment weiXinFragment = new WeiXinFragment();
		ft.add(R.id.fragmentRoot, weiXinFragment, "weiXinFragment");
		ft.addToBackStack("weiXinFragment");
		ft.commit();		
	}
	/**
	 * 处理底部点击事件
	 */
	private void dealBottomButtonsClickEvent() { 
		findViewById(R.id.rbWeiXin).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(fMgr.findFragmentByTag("weiXinFragment")!=null && fMgr.findFragmentByTag("weiXinFragment").isVisible()) {
					return;
				}
				popAllFragmentsExceptTheBottomOne();

			}
		});
		findViewById(R.id.rbAddress).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popAllFragmentsExceptTheBottomOne();
				FragmentTransaction ft = fMgr.beginTransaction();
				ft.hide(fMgr.findFragmentByTag("weiXinFragment"));
				AddressFragment sf = new AddressFragment();
				ft.add(R.id.fragmentRoot, sf, "AddressFragment");
				ft.addToBackStack("AddressFragment");
				ft.commit();
				
			}
		});
		findViewById(R.id.rbFind).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popAllFragmentsExceptTheBottomOne();
				FragmentTransaction ft = fMgr.beginTransaction();
				ft.hide(fMgr.findFragmentByTag("weiXinFragment"));
				FindFragment sf = new FindFragment();
				ft.add(R.id.fragmentRoot, sf, "AddressFragment");
				ft.addToBackStack("FindFragment");
				ft.commit();
			}
		});
		findViewById(R.id.rbMe).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popAllFragmentsExceptTheBottomOne();
				FragmentTransaction ft = fMgr.beginTransaction();
				ft.hide(fMgr.findFragmentByTag("weiXinFragment"));
				MeFragment sf = new MeFragment();
				ft.add(R.id.fragmentRoot, sf, "MeFragment");
				ft.addToBackStack("MeFragment");
				ft.commit();
			}
		});
	}
	
	/**
	 * 从back stack弹出所有的fragment，保留首页的那个
	 */
	public static void popAllFragmentsExceptTheBottomOne() {
		for (int i = 0, count = fMgr.getBackStackEntryCount() - 1; i < count; i++) {
			fMgr.popBackStack();
		}
	}
	//点击返回按钮
	@Override
	public void onBackPressed() {
		if(fMgr.findFragmentByTag("weiXinFragment")!=null && fMgr.findFragmentByTag("weiXinFragment").isVisible()) {
			MainActivity.this.finish();
		} else {
			super.onBackPressed();
		}
	}
}
