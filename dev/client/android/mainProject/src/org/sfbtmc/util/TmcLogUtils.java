package org.sfbtmc.util;

import android.util.Log;

public class TmcLogUtils {
	private static boolean SHOW = true; 
	private static String TAG = "tmclog";
	
	public static void d(String tag,String msg){
		if(SHOW){
			Log.d(tag, msg);
		}
	}
	public static void d(String msg){
		if(SHOW){
			Log.d(TAG,msg);
		}
	}
	public static void e(String tag,String msg){
		if(SHOW){
			Log.e(tag,msg);
		}
	}
	public static void e(String msg){
		if(SHOW){
			Log.e(TAG,msg);
		}
	}
	
}
