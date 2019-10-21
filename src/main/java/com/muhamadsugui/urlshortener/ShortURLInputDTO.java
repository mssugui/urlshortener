package com.muhamadsugui.urlshortener;

import lombok.Getter;

@Getter
public class ShortURLInputDTO {
	
	private String forwardURL;
	
	public ShortURL transformToShortURL() {
		return new ShortURL(this.forwardURL);
	}

}
