package com.muhamadsugui.urlshortener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class ShortenedURLService {

	private final ShortURLsRepository repository;
	private URLShortenerEngine urlShortenerEngine;
	
	@Value("${shortenedURL.baseHostname}")
	private String baseHostname;


	@Autowired
	public ShortenedURLService(ShortURLsRepository restRepository) {
		this.repository = restRepository;
		this.urlShortenerEngine = new URLShortenerEngine();
	}

	public ShortURL save(ShortURL shortURL) {
		String forwardURL = shortURL.getForwardURL();
		String candidateKey = urlShortenerEngine.generateKey(forwardURL);

		if (!repository.existsById(candidateKey)) {
			// If candidateKey is not stored, shortURL is stored as a new record.
			shortURL.setId(candidateKey);
		} else {
			ShortURL possibleMatch = repository.findById(candidateKey).get();
			if (possibleMatch.getForwardURL().equals(shortURL.getForwardURL())) {
				// If candidateKey exists and is the same forwardURL, increments hits
				// statistics.
				shortURL = possibleMatch;
				shortURL.incrementHits();
			} else {
				// If candidateKey exists and is not the same URL, it was a collision and a new
				// candidateKey has to be calculated.
				candidateKey = urlShortenerEngine.generateKeyWithSalt(forwardURL);
				while (repository.existsById(candidateKey)) {
					candidateKey = urlShortenerEngine.generateKeyWithSalt(forwardURL);
				}
				shortURL.setId(candidateKey);
			}
		}
		ShortURL response = repository.save(shortURL);
		return response;
	}

	public List<ShortURL> getAllURLs() {
		return (List<ShortURL>) repository.findAll();
	}

	public ShortURL findById(String id) {
		if (id.length() == urlShortenerEngine.getKEY_LENGTH()) {
			if (repository.existsById(id)) {
				return repository.findById(id).get();
			}
		}
		throw new ShortURLNotFoundException(id);
	}

	public List<ShortURL> getMostRequested(Integer maxRecords) {
		Pageable paging = PageRequest.of(0, maxRecords, Sort.by("totalHits"));
		Page<ShortURL> pagedResult = repository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		}
		return new ArrayList<ShortURL>();
	}

	public List<ShortURL> getHigherThan(Integer page, Integer pageSize, Long minHits) {
		Pageable paging = PageRequest.of(page, pageSize, Sort.by("totalHits"));
		Page<ShortURL> pagedResult = repository.findByHigherThan(paging, minHits);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		}
		return new ArrayList<ShortURL>();
	}
}
