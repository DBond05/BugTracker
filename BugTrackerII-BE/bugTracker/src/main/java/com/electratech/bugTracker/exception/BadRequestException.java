package com.electratech.bugTracker.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5362833731364170474L;

	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BadRequestException(String message) {
		super(message);
		
	}
}
