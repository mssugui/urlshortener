package com.muhamadsugui.urlshortener;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortenedURLService {
	
	private final ShortURLsRepository repository;
	
	@Autowired
	public ShortenedURLService(ShortURLsRepository restRepository) {
		this.repository = restRepository;
	}
	
	@Transactional
	public ShortURL save(ShortURL shortURL) {
		ShortURL response = repository.save(shortURL);
		return response;
	}

	public List<ShortURL> getAllURLs() {
		return (List<ShortURL>) repository.findAll();
	}

}
