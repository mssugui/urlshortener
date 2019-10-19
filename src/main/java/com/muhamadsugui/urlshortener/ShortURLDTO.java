package com.muhamadsugui.urlshortener;

import lombok.Getter;

@Getter
public class ShortURLDTO {
	
	private String forwardURL;
	
	public ShortURL transformToShortURL() {
		return new ShortURL(this.forwardURL);
	}

}
