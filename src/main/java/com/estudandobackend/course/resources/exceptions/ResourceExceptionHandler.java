package com.estudandobackend.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudandobackend.course.services.exceptions.DatabaseException;
import com.estudandobackend.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice  // isso que vai interceptar as excecoes que ocorrerem para que esse objeto possa executar um possivel tratamento
public class ResourceExceptionHandler {

	// Com essa anotation, esse metodo vai interceptar qualquer excecao de mesmo tipo lancada e sera feito o tratamento 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;  // code 404
		StandardError se = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(se);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST; 
		StandardError se = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(se);
	}
}
