package org.sfbtmc.net;

public class TmcServerConfig {
	public static final String BASE_URL = "http://54.64.18.163:8080/ToastmastersServicesWeb/";
	public static final String NEW_VER_CHECK="https://raw.githubusercontent.com/SFB-TMC/TMC/master/dev/client/android/check_update.json";
	
	
	
	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}
}
