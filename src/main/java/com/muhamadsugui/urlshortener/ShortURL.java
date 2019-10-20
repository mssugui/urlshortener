package com.muhamadsugui.urlshortener;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ShortURL {
	
	@Id
	private String id;
	
	private String forwardURL;
		
	private Long totalHits;
	
	public ShortURL(String forwardURL) {
		this.forwardURL = forwardURL;
	}

}
