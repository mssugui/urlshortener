package com.muhamadsugui.urlshortener;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ShortURLNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(ShortURLNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String shortURLNotFoundHandler(ShortURLNotFoundException ex) {
		return ex.getMessage();
	}
}
