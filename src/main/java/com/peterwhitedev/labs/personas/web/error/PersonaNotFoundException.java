package com.peterwhitedev.labs.personas.web.error;

public class PersonaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonaNotFoundException(String message) {
		super(message);
	}

}
