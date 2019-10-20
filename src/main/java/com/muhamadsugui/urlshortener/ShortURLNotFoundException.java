package com.muhamadsugui.urlshortener;

public class ShortURLNotFoundException extends RuntimeException {

	ShortURLNotFoundException(String id) {
		super("Could not find shortURL:" + id);
	}

}
