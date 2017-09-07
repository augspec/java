package com.aug.money.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author HungDMc
 *
 */
public class SHA2Util {

	public static String hash(String strToHash) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(strToHash.getBytes());
		
		byte[] byteData = md.digest();
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
		return sb.toString();
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(SHA2Util.hash("123456"));
	}
}
