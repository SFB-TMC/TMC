package org.sfbtmc.net;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * a Static Http Client
 * 
 * @author Administrator
 * 
 */
public class TmcClient {
	private static final String BASE_URL = "http://api.twitter.com/1/";

	private static AsyncHttpClient client = new AsyncHttpClient();

	// public static void get(String url, RequestParams params,
	// AsyncHttpResponseHandler responseHandler) {
	// client.get(getAbsoluteUrl(url), params, responseHandler);
	// }
	//
	// public static void post(String url, RequestParams params,
	// AsyncHttpResponseHandler responseHandler) {
	// client.post(getAbsoluteUrl(url), params, responseHandler);
	// }

	public static void get(String url, RequestParams params,
			TmcJsonHttpResponseHandler responseHandler) {
		client.get(getAbsoluteUrl(url), params, responseHandler);
	}

	public static void post(String url, RequestParams params,
			TmcJsonHttpResponseHandler responseHandler) {
		client.post(getAbsoluteUrl(url), params, responseHandler);
	}

	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}
}
