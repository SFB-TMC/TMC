package org.sfbtmc.net;

public class TmcServerConfig {
	private static final String BASE_URL = "http://api.twitter.com/1/";
	public static final String NEW_VER_CHECK="https://raw.githubusercontent.com/SFB-TMC/TMC/master/dev/client/android/check_update.json";
	
	
	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}
}
