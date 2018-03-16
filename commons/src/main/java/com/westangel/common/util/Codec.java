package com.westangel.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class Codec {

	/**
	 * @return an UUID String
	 */
	public static String UUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * Encode a String to base64
	 * 
	 * @param value
	 *            The plain String
	 * @return The base64 encoded String
	 * @throws Exception
	 */
	public static String encodeBASE64(String value) {
		try {
			return new String(Base64.encodeBase64(value.getBytes("utf-8")));
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Encode binary data to base64
	 * 
	 * @param value
	 *            The binary data
	 * @return The base64 encoded String
	 */
	public static String encodeBASE64(byte[] value) {
		return new String(Base64.encodeBase64(value));
	}

	/**
	 * Decode a base64 value
	 * 
	 * @param value
	 *            The base64 encoded String
	 * @return decoded binary data
	 * @throws Exception
	 */
	public static byte[] decodeBASE64(String value) {
		try {
			return Base64.decodeBase64(value.getBytes("utf-8"));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Build an hexadecimal MD5 hash for a String
	 * 
	 * @param value
	 *            The String to hash
	 * @return An hexadecimal Hash
	 * @throws Exception
	 */
	public static String hexMD5(String value) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(value.getBytes("utf-8"));
			byte[] digest = messageDigest.digest();
			return byteToHexString(digest);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Build an hexadecimal SHA1 hash for a String
	 * 
	 * @param value
	 *            The String to hash
	 * @return An hexadecimal Hash
	 * @throws Exception
	 */
	public static String hexSHA1(String value) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-1");
			md.update(value.getBytes("utf-8"));
			byte[] digest = md.digest();
			return byteToHexString(digest);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Write a byte array as hexadecimal String.
	 */
	public static String byteToHexString(byte[] bytes) {
		return String.valueOf(Hex.encodeHex(bytes));
	}

	/**
	 * Transform an hexadecimal String to a byte array.
	 * 
	 * @throws Exception
	 */
	public static byte[] hexStringToByte(String hexString) {
		try {
			return Hex.decodeHex(hexString.toCharArray());
		} catch (DecoderException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * MD5加密
	 */
	public static String MD5Code(String pass) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(pass.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}
}
