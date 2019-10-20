package com.muhamadsugui.urlshortener;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class URLShortenerEngineTest {
	
	private URLShortenerEngine urlShorterEngine;

	public URLShortenerEngineTest() {
		urlShorterEngine = new URLShortenerEngine();
	}

	@Test
	void testGenerateKey() {
		String input = "https://www.linkedin.com/in/muhamadsugui/";
		String output = urlShorterEngine.generateKey(input);
		assertEquals("ffc27ac8", output);
	}

	@Test
	void testGenerateKeyWithSalt() {
		String input = "http://www.google.com";
		String output = urlShorterEngine.generateKeyWithSalt(input);
		int expectedLength = 8;
		assertEquals(expectedLength,output.length());
	}
	
	@Test
	void testGenerateKeyWithSaltVariation() {
		String input = "http://www.google.com";
		String output_1 = urlShorterEngine.generateKeyWithSalt(input);
		String output_2 = urlShorterEngine.generateKeyWithSalt(input);
		assertNotEquals(output_1, output_2);
	}
}
