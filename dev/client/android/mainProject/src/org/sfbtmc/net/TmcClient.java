package org.sfbtmc.net;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

/**
 * a Static Http Client
 * 
 * @author Administrator
 * 
 */
public class TmcClient extends AsyncHttpClient{
	
	private TmcJsonHttpResponseHandler responseHandler;
	private JsonHttpResponseHandler jsonHandler;
	
	public TmcClient(){
		jsonHandler = new JsonHttpResponseHandler(){

			@Override
			public void onFailure(int statusCode, Header[] headers,
					Throwable throwable, JSONObject errorResponse) {
				
				responseHandler.onTmcFailure(statusCode, throwable, errorResponse);
				
			}

			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				int status = response.optInt("status",-1);
				if(0 != status){ //server tell us that something is wrong.
					
					return;
				}
				
				
			
			}

			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONArray response) {
				
			}
			
		};
	}

	public RequestHandle tmcGet(String url, RequestParams params,
			TmcJsonHttpResponseHandler respHandler) {
		this.responseHandler = respHandler;
		return super.get(url, params, jsonHandler);
	}

	public RequestHandle tmcGet(String url,
			TmcJsonHttpResponseHandler respHandler) {
		this.responseHandler = respHandler;
		return super.get(url, jsonHandler);
	}

	public RequestHandle tmcPost(String url, RequestParams params,
			TmcJsonHttpResponseHandler respHandler) {
		this.responseHandler = respHandler;
		return super.post(url, params, jsonHandler);
	}

	public RequestHandle tmcPost(String url,
			TmcJsonHttpResponseHandler respHandler) {
		this.responseHandler = respHandler;
		return super.post(url, jsonHandler);
	}

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
