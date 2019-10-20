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
		
	private long totalHits;
	
	public ShortURL(String forwardURL) {
		this.forwardURL = forwardURL;
	}

	public void incrementHits() {
		this.totalHits++;
	}

}
