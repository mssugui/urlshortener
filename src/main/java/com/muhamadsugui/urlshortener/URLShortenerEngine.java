package com.muhamadsugui.urlshortener;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class URLShortenerEngine {

	private static Random randomToken;
	private MessageDigest md5;
	/**
	 * This algorithm is based on MD5, which generates hexadecimal digits, so, 
	 * a String with length 8 allows the database to hold up to 4.294.967.296 of shortened URLs.
	 * 
	 */
	private final int KEY_LENGTH = 8;
	
	static {
		randomToken = new Random(System.currentTimeMillis());
	}

	public int getKEY_LENGTH() {
		return KEY_LENGTH;
	}

	String generateKey(String forwardURL) {
		String md5EncodedStr = calculateMD5(forwardURL);
		return md5EncodedStr.substring(0, KEY_LENGTH);
	}

	/**
	 * Intended to be used when the generatedKey collided with a previously stored key, but
	 * pointing to a different forwardURL.
	 * 
	 **/
	String generateKeyWithSalt(String forwardURL) {
		String randomChunk = generateRandomChunk();
		String md5EncodedStr = calculateMD5(forwardURL + randomChunk);
		return md5EncodedStr.substring(0, KEY_LENGTH);
	}

	private String calculateMD5(String inputStr) {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md5.update(inputStr.getBytes());
		String md5Encoded = new BigInteger(1, md5.digest()).toString(16);
		return md5Encoded;
	}

	private String generateRandomChunk() {
		byte[] randomChunk = new byte[5];
		randomToken.nextBytes(randomChunk);

		return new String(randomChunk);
	}

}
