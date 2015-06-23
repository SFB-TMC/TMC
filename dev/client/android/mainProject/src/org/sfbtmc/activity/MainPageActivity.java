package org.sfbtmc.activity;

import org.json.JSONObject;
import org.sfbtmc.R;
import org.sfbtmc.TmcManager;
import org.sfbtmc.bean.MainPageListBean;
import org.sfbtmc.bean.MainPageMsgBean;
import org.sfbtmc.net.TmcClient;
import org.sfbtmc.net.TmcJsonHttpResponseHandler;
import org.sfbtmc.net.TmcServerConfig;
import org.sfbtmc.widget.MainPageMenuPopWindow;
import org.sfbtmc.widget.MainPageMenuPopWindow.OnPopMenuClickListener;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.loopj.android.http.RequestParams;

public class MainPageActivity extends FragmentActivity implements
		OnClickListener, OnPopMenuClickListener {

	private MainPageMenuPopWindow morePopWindow;
	private PullToRefreshListView mainPullList;
	private MainPageMsgBean mainPageMsgBean;
	private int curMsgPageIndex = 0;

	private final static SparseArray<Class<?>> MENU_ID = new SparseArray<Class<?>>(
			0);
	static {
		MENU_ID.put(R.id.mainpage_pop_menu_notification,
				NotificationActivity.class);
		MENU_ID.put(R.id.mainpage_pop_menu_special_column,
				SpecialColumnActivity.class);
		MENU_ID.put(R.id.mainpage_pop_menu_agenda, AgendaActivity.class);
		MENU_ID.put(R.id.mainpage_pop_menu_doc, DocDetailActivity.class);
		MENU_ID.put(R.id.mainpage_pop_menu_activity, ActivityActivity.class);
		// MENU_ID.put(R.id.mainpage_pop_menu_3, .class);
		// MENU_ID.put(R.id.mainpage_pop_menu_exit, null);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		morePopWindow = new MainPageMenuPopWindow(this);
		morePopWindow.setOnMenuClickListener(this);
		
		mainPullList = (PullToRefreshListView) findViewById(R.id.main_page_pull_refresh_list);
		mainPullList.setMode(Mode.PULL_FROM_END);
		mainPullList.setOnRefreshListener(new OnRefreshListener<ListView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				queryData(curMsgPageIndex);
			}
			
		});
		
		
		
		mainPullList.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position,
					long id) {
				//这里的position是从1开始的,和原生的listView不一样.因为pullListView 用了一个headerView
				MainPageListBean listBean = mainPageMsgBean.getMsgBeanList().get(position - 1);
				viewDetailMainPageListMsg(listBean);
			}
		});
		
		
		queryData(curMsgPageIndex);
		initData();
	}
	
	private void viewDetailMainPageListMsg(MainPageListBean listBean){
		int type = listBean.getType();
		if(type == MainPageListBean.BEAN_TYPE_ACTIVITY){
			Intent in = new Intent(this,ActivityActivity.class);
			startActivity(in);
		}
		if(type == MainPageListBean.BEAN_TYPE_MEETING){
			Intent in = new Intent(this,AgendaActivity.class);
			startActivity(in);
		}
		if(type == MainPageListBean.BEAN_TYPE_NOTICE){
			Intent in = new Intent(this,DocDetailActivity.class);
			startActivity(in);
		}
	}
	
	/**
	 * query from server with page index.
	 * @param pageNo page index,start from 0;
	 */
	private void queryData(final int pageNo) {
		TmcClient client = TmcClient.getInstance();
		RequestParams params = new RequestParams();
		params.add("clubNO", TmcManager.getInstance().getUserBean().getClubNO());
		params.add("pageNo", ""+pageNo);
		client.tmcPost(TmcServerConfig.BASE_URL + "tmc/gainRecommandList", params, new TmcJsonHttpResponseHandler(){

			@Override
			public void onRequestError(int statusCode, Throwable throwable,
					JSONObject errorResponse) {
				super.onRequestError(statusCode, throwable, errorResponse);
				
				
			}

			@Override
			public void onTmcFailure(int statusCode, JSONObject errorResponse) {
				super.onTmcFailure(statusCode, errorResponse);
				
				
			}

			@Override
			public void onTmcSuccess(int statusCode, JSONObject response) {
				super.onTmcSuccess(statusCode, response);
				if(curMsgPageIndex == 1){
					mainPageMsgBean.initFromJson(response);
				}else{
					mainPageMsgBean.addMsgBeanList(response.optJSONArray("list"));
				}
			}
			
		});
		
		curMsgPageIndex = pageNo + 1;
	}

	private void initData(){
		mainPageMsgBean = new MainPageMsgBean();
		
		mainPullList.setAdapter(new MainPullListAdapter(this));
	}
	
	class MainPullListAdapter extends BaseAdapter{
		Context ctx;
		public MainPullListAdapter(Context context){
			this.ctx = context;
		}
		@Override
		public int getCount() {
			return mainPageMsgBean.getMsgBeanList().size();
		}

		@Override
		public Object getItem(int arg0) {
			return mainPageMsgBean.getMsgBeanList().get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parentView) {
			if(null == convertView){
				convertView =LayoutInflater.from(ctx).inflate(R.layout.layout_mainpage_message_item, parentView, false);
			}
			
			return convertView;
		}
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_title_menu_img:
			morePopWindow.showPopupWindow(v);
			break;
		default:
			break;
		}
	}

	// 点击返回按钮
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	public void onClickMenu(View clickedMenu) {
		Class<?> clazz = MENU_ID.get(clickedMenu.getId());
		if (null != clazz) {
			morePopWindow.dismiss();
			startActivity(new Intent(this, clazz));
		} else if (clickedMenu.getId() == R.id.mainpage_pop_menu_exit) {
			this.finish();
		}
	}
}
