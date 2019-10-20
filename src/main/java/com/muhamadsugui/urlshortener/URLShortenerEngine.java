package com.muhamadsugui.urlshortener;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class URLShortenerEngine {

	private Random randomToken;
	private MessageDigest md5;
	private final int KEY_LENGTH = 8;

	/**
	 * Generates a String with length 8 that can be used as the key to a
	 * {@link com.muhamadsugui.urlshortener.ShortURL shortURL}.
	 * <br>
	 * This algorithm is based on MD5, which generates hexadecimal digits, so, 
	 * a String with length 8 allows the database to hold up to 4.294.967.296 of shortened URLs.
	 *
	 * 
	 **/
	String generateIdToURL(String forwardURL) {
		String randomChunk = generateRandomChunk();
		String md5EncodedStr = generateMD5FromString(forwardURL + randomChunk);
		return md5EncodedStr.substring(0, KEY_LENGTH);
	}

	/**
	 * Default visibility only for the sake of testing.
	 *
	 * Use {@link #generateIdToURL(String) calculateURLHash} instead.
	 *
	 **/
	String generateMD5FromString(String inputString) {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md5.update(inputString.getBytes());
		String md5Encoded = new BigInteger(1, md5.digest()).toString(16);
		return md5Encoded;
	}

	private String generateRandomChunk() {
		randomToken = new Random(System.currentTimeMillis());
		byte[] randomChunk = new byte[5];
		randomToken.nextBytes(randomChunk);

		return new String(randomChunk);
	}

}
