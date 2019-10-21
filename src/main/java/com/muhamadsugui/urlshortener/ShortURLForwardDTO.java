package com.muhamadsugui.urlshortener;

import lombok.Getter;

@Getter
public class ShortURLForwardDTO {
	
	private String forwardURL;
	
	private ShortURLForwardDTO(String forwardURL) {
		this.forwardURL = forwardURL;
	}
	
	public static ShortURLForwardDTO transformToShortURLForwardDTO(ShortURL shortURL) {
		return new ShortURLForwardDTO(shortURL.getForwardURL());
				
	}

}
