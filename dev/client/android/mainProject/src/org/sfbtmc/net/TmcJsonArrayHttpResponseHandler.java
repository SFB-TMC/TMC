package org.sfbtmc.net;

import org.json.JSONArray;
import org.json.JSONObject;

import com.loopj.android.http.JsonHttpResponseHandler;

public class TmcJsonArrayHttpResponseHandler extends JsonHttpResponseHandler {

	
	public void onTmcFailure(int statusCode,
			Throwable throwable, JSONObject errorResponse) {
		
	}

	public void onTmcSuccess(int statusCode,
			JSONArray responseArr) {
	}
	
}
