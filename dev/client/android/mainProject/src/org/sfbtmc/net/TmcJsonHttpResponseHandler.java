package org.sfbtmc.net;

import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;

public class TmcJsonHttpResponseHandler extends JsonHttpResponseHandler {
	
	/**
	 * 这个是网络发生了错误,没请求到数据的错误
	 * @param statusCode
	 * @param throwable
	 * @param errorResponse
	 */
	public void onRequestError(int statusCode,
			Throwable throwable, JSONObject errorResponse) {
		
	}

	/**
	 * 这个是请求是成功返回的,但是服务端认为发生了错误,此时应该在 errorResponse 中去获取data的信息.
	 * @param statusCode
	 * @param errorResponse
	 */
	public void onTmcFailure(int statusCode, JSONObject errorResponse) {
		
	}

	/**
	 * 当网络正常,也返回了正确的数据的回调
	 * @param statusCode
	 * @param response
	 */
	public void onTmcSuccess(int statusCode,
			JSONObject response) {
		
	}

	
}
