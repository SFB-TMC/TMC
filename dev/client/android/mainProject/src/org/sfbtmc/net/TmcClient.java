package org.sfbtmc.net;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;
import org.sfbtmc.util.TmcLogUtils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

/**
 * a TMC Http Client
 * 
 * @author Administrator
 * 
 */
public class TmcClient extends AsyncHttpClient{
	private static TmcClient tmcClient = null;  
	
	private final String TAG = "TmcClient"; 
	private TmcJsonHttpResponseHandler tmcRespJsonHandler = null;
	private TmcJsonArrayHttpResponseHandler tmcRespJsonArrayHandler = null;
	private JsonHttpResponseHandler jsonHandler = null;
	
	private TmcClient(){
		jsonHandler = new JsonHttpResponseHandler(){

			@Override
			public void onFailure(int statusCode, Header[] headers,
					Throwable throwable, JSONObject errorResponse) {
				TmcLogUtils.e(TAG, "onFailure");
				tmcRespJsonHandler.onRequestError(statusCode, throwable, errorResponse);
			}

			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				int status = response.optInt("status",-1);
				if(0 != status){ //server tell us that something is wrong.
					TmcLogUtils.e(TAG, "server return -1,that is tell us that something is wrong");
					
					tmcRespJsonHandler.onTmcFailure(statusCode,response);
					
					return;
				}
				if(null != tmcRespJsonHandler){
					tmcRespJsonHandler.onTmcSuccess(statusCode, response.optJSONObject("data"));
				}else{
					tmcRespJsonArrayHandler.onTmcSuccess(statusCode, response.optJSONArray("data"));
				}
			}
		};
	}
	
	
	public static TmcClient getInstance(){
		if(null == tmcClient){
			tmcClient = new TmcClient();
		}
		return tmcClient;
	}

	public RequestHandle tmcPost(String url, RequestParams params,
			TmcJsonHttpResponseHandler respHandler) {
		this.tmcRespJsonHandler = respHandler;
		return super.post(url, params, jsonHandler);
	}
	
	public RequestHandle tmcPost(String url, RequestParams params,
			TmcJsonArrayHttpResponseHandler respHandler) {
		this.tmcRespJsonArrayHandler = respHandler;
		return super.post(url, params, jsonHandler);
	}
	
//	public RequestHandle tmcGet(String url, RequestParams params,
//			TmcJsonHttpResponseHandler respHandler) {
//		this.responseHandler = respHandler;
//		return super.get(url, params, jsonHandler);
//	}
//
//	public RequestHandle tmcGet(String url,
//			TmcJsonHttpResponseHandler respHandler) {
//		this.responseHandler = respHandler;
//		return super.get(url, jsonHandler);
//	}

//	public RequestHandle tmcPost(String url,
//			TmcJsonHttpResponseHandler respHandler) {
//		this.responseHandler = respHandler;
//		return super.post(url, jsonHandler);
//	}

//	private static AsyncHttpClient client = new AsyncHttpClient();
	
	

	// public static void get(String url, RequestParams params,
	// AsyncHttpResponseHandler responseHandler) {
	// client.get(getAbsoluteUrl(url), params, responseHandler);
	// }
	//
	// public static void post(String url, RequestParams params,
	// AsyncHttpResponseHandler responseHandler) {
	// client.post(getAbsoluteUrl(url), params, responseHandler);
	// }

//	public static void get(String url, RequestParams params,
//			TmcJsonHttpResponseHandler responseHandler) {
//		client.get(getAbsoluteUrl(url), params, responseHandler);
//	}
//
//	public static void post(String url, RequestParams params,
//			TmcJsonHttpResponseHandler responseHandler) {
//		client.post(getAbsoluteUrl(url), params, responseHandler);
//	}

	
}
