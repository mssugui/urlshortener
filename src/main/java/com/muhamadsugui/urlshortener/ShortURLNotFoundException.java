package com.muhamadsugui.urlshortener;

@SuppressWarnings("serial")
public class ShortURLNotFoundException extends RuntimeException {

	ShortURLNotFoundException(String id) {
		super("Could not find shortURL:" + id);
	}

}
