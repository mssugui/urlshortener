package com.muhamadsugui.urlshortener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenedURLController {

	private final ShortenedURLService shortURLService;

	@Autowired
	public ShortenedURLController(ShortenedURLService shortenedURLService) {
		this.shortURLService = shortenedURLService;
	}

	@PostMapping("/urls")
	public ResponseEntity<ShortURLShortenedDTO> save(@RequestBody ShortURLInputDTO shortURLDTO) {
		ShortURL shortURL = shortURLService.save(shortURLDTO.transformToShortURL());
		return new ResponseEntity<>(ShortURLShortenedDTO.transformToShortURLShortenedDTO(shortURL), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ShortURLForwardDTO getById(@PathVariable String id) {
		ShortURL shortURL = shortURLService.findById(id);
		return ShortURLForwardDTO.transformToShortURLForwardDTO(shortURL);
	}

	@GetMapping("/statistics/list")
	public List<ShortURL> all() {
		return shortURLService.getAllURLs();
	}

	@GetMapping("/statistics/higherThan")
	public List<ShortURL> getHigherThan(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id") Long minHits) {
		return shortURLService.getHigherThan(page,pageSize,minHits);
	}

	@GetMapping("/statistics/mostRequested/{topHits}")
	public List<ShortURL> getMostRequested(@PathVariable Integer topHits) {
		if (topHits > 100) {
			topHits = 100;
		}
		return shortURLService.getMostRequested(topHits);
	}
	
	@GetMapping("/statistics/count")
	public Long getNumRecords() {
		return shortURLService.getNumRecords();
	}
	
}
