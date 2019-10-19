package com.muhamadsugui.urlshortener;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ShortURL {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String forwardURL;
	
	private String shortenedURL;
	
	private Long totalHits;
	
	public ShortURL(String forwardURL) {
		this.forwardURL = forwardURL;
	}

}
