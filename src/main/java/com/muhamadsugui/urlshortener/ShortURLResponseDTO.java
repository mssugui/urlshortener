package com.muhamadsugui.urlshortener;

import lombok.Getter;

@Getter
public class ShortURLResponseDTO {
	
	private String shortenedURL;
	
	private ShortURLResponseDTO(String id) {
		this.shortenedURL = UrlshortenerApplication.HOSTNAME+id;
	}
	
	public static ShortURLResponseDTO transformToShortURL(ShortURL shortURL) {
		return new ShortURLResponseDTO(shortURL.getId());
				
	}

}
