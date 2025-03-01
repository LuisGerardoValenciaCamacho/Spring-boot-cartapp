package com.cartapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceBadRequest extends RuntimeException {
	public ResourceBadRequest(Class<?> resourceClass, String message) {
		super(resourceClass.getSimpleName() + ": " + message);
	}
}