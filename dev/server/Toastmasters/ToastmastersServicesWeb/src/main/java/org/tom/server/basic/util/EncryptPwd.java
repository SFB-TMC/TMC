package org.tom.server.basic.util;

import java.security.MessageDigest;

public class EncryptPwd {

	/**
	 * ���ַ������м��ܴ���
	 * 
	 * @param strString
	 * @return ���ܺ���ַ���
	 */
	public static String encrypt(String strString) {
		if (strString != null) {
			strString += "pwd";
			try {
				// ����MD5�㷨����ϢժҪ
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(strString.getBytes());

				// ���õ����ֽ��������ַ�������
				String resultString = byteArrayToHexString(results);
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * �ַ�����תʮ��λ�ַ���
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
