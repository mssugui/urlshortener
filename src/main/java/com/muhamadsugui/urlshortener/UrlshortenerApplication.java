package com.muhamadsugui.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlshortenerApplication {

	public static final String HOSTNAME = "http://localhost:8080/";

	public static void main(String[] args) {
		SpringApplication.run(UrlshortenerApplication.class, args);
	}

}
