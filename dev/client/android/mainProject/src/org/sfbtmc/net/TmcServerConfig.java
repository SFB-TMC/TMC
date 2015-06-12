package org.sfbtmc.net;

public class TmcServerConfig {
	private static final String BASE_URL = "http://api.twitter.com/1/";
	
	
	private static String getAbsoluteUrl(String relativeUrl) {
		return BASE_URL + relativeUrl;
	}
}
