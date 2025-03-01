package com.cartapp.model;

import java.time.LocalDateTime;

public class Error {

private String message;
	
	private String error;
	
	private int status;
	
	private LocalDateTime date;

	public Error() {
		super();
	}

	public Error(String message, String error, int status, LocalDateTime date) {
		super();
		this.message = message;
		this.error = error;
		this.status = status;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
