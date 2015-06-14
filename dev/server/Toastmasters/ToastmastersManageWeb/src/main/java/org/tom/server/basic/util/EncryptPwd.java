package org.tom.server.basic.util;

import java.security.MessageDigest;

public class EncryptPwd {

	/**
	 * 对字符串进行加密处理
	 * 
	 * @param strString
	 * @return 加密后的字符串
	 */
	public static String encrypt(String strString) {
		if (strString != null) {
			strString += "pwd";
			try {
				// 创建MD5算法的信息摘要
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(strString.getBytes());

				// 将得到的字节数组变成字符串返回
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 字符数组转十六位字符串
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
