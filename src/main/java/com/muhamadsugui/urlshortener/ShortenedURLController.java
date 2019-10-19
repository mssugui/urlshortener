package com.muhamadsugui.urlshortener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenedURLController {

	private final ShortenedURLService shortURLService;

	@Autowired
	public ShortenedURLController(ShortenedURLService shortenedURLService) {
		this.shortURLService = shortenedURLService;
	}

	@PostMapping("/urls")
	public ResponseEntity<ShortURL> save(@RequestBody ShortURLDTO shortURLDTO) {
		ShortURL shortURL = shortURLService.save(shortURLDTO.transformToShortURL());
		return new ResponseEntity<>(shortURL, HttpStatus.CREATED);
	}

	@GetMapping("/urls")
	public List<ShortURL> all() {
		return shortURLService.getAllURLs();
	}
}
