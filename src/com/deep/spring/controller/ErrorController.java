package com.deep.spring.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

	@ExceptionHandler(Exception.class)
	public String handleError(Exception ex) {
		return "errorPage";
	}
	
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseError(DataAccessException dex) {
		return "errorPage";
	}
}
