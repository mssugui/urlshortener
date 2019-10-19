package com.muhamadsugui.urlshortener;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortURLsRepository extends CrudRepository<ShortURL, Long>{

}
