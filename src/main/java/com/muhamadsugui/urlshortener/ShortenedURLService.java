package com.muhamadsugui.urlshortener;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortenedURLService {
	
	private final ShortURLsRepository repository;
	private URLShortenerEngine urlShortenerEngine;
	
	@Autowired
	public ShortenedURLService(ShortURLsRepository restRepository) {
		this.repository = restRepository;
		this.urlShortenerEngine = new URLShortenerEngine();
	}
	
	@Transactional
	public ShortURL save(ShortURL shortURL) {
		String forwardURL = shortURL.getForwardURL();
		shortURL.setId(urlShortenerEngine.generateIdToURL(forwardURL));
		ShortURL response = repository.save(shortURL);
		return response;
	}

	public List<ShortURL> getAllURLs() {
		return (List<ShortURL>) repository.findAll();
	}

}
