package org.second.secondseminar.exception.model;

import org.second.secondseminar.exception.Error;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
	private final Error error;

	public CustomException(Error error, String message) {
		super(message);
		this.error = error;
	}

	public int getHttpStatus() {
		return error.getErrorCode();
	}
}
