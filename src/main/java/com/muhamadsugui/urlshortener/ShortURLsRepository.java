package com.muhamadsugui.urlshortener;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortURLsRepository extends PagingAndSortingRepository<ShortURL, String>{
	
	@Query("SELECT s FROM ShortURL s WHERE s.totalHits > ?1 ORDER BY s.totalHits desc")
	public Page<ShortURL> findByHigherThan(Pageable pageable, Long numRecords);

	@Query("SELECT s FROM ShortURL s WHERE s.totalHits > ?1 ORDER BY s.totalHits desc")
	public List<ShortURL> findByTopMostRequested(Pageable pageable);

}
