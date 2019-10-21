package com.muhamadsugui.urlshortener;

import lombok.Getter;

@Getter
public class ShortURLShortenedDTO {
	
	private String shortenedURL;
	
	private ShortURLShortenedDTO(String id) {
		this.shortenedURL = UrlshortenerApplication.HOSTNAME+id;
	}
	
	public static ShortURLShortenedDTO transformToShortURLShortenedDTO(ShortURL shortURL) {
		return new ShortURLShortenedDTO(shortURL.getId());
				
	}

}
