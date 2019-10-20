package com.muhamadsugui.urlshortener;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class URLShortenerEngineTest {
	
	private URLShortenerEngine urlShorterEngine;

	public URLShortenerEngineTest() {
		urlShorterEngine = new URLShortenerEngine();
	}

	@Test
	void testCalculateURLHash() {
		String input = "https://www.linkedin.com/in/muhamadsugui/";
		String output = urlShorterEngine.generateMD5FromString(input);
		String expectedOutput = "ffc27ac8bafdca4f6d0c79b9ef621311";
		assertEquals(expectedOutput,output);
	}

	@Test
	void testGenerateIdToURL() {
		String input = "http://www.google.com";
		String output = urlShorterEngine.generateIdToURL(input);
		int expectedLength = 8;
		assertEquals(expectedLength,output.length());
	}
	
}
