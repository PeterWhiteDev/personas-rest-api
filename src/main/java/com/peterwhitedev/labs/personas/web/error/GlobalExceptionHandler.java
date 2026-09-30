package com.peterwhitedev.labs.personas.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PersonaNotFoundException.class)
	public ResponseEntity<ApiRecord> handlePersonaNotFoundException(PersonaNotFoundException ex) {
		ApiRecord apiRecord = new ApiRecord(ex.getMessage(), System.currentTimeMillis());		
		return new ResponseEntity<>(apiRecord, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ApiRecord> handleIllegalArgumentException(IllegalArgumentException ex) {
		ApiRecord apiRecord = new ApiRecord(ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(apiRecord, HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<ApiRecord> handleGenericException(Exception ex) {
		ApiRecord apiRecord = new ApiRecord("Error interno del servidor", System.currentTimeMillis());
		return new ResponseEntity<>(apiRecord, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}