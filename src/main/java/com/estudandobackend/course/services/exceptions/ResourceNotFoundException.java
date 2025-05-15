package com.estudandobackend.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {  // id que tentamos encontrar
		super("Resource not found. Id " + id);		
	}
}
