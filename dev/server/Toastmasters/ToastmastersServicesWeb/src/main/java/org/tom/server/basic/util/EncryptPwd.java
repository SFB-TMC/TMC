package org.tom.server.basic.util;

import java.security.MessageDigest;

public class EncryptPwd {

	/**
	 * encrypt string
	 * 
	 * @param strString
	 * @return 
	 */
	public static String encrypt(String strString) {
		if (strString != null) {
			strString += "pwd";
			try {
				// create md5
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(strString.getBytes());

				// char array transfer to 16 String
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * char array transfer to 16 String
	 * @param b
	 * @return
	 */
	private static String byteArrayToHexString(byte[] b) {
		
		StringBuffer sb = new StringBuffer(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString().toUpperCase();
	}

	public static void main(String[] args) {
		
		System.out.println(encrypt("123456"));
	}
}
