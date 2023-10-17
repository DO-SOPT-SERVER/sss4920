package com.server.dosopt.seminar.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CommonSuccess {

	/**
	 * 200 OK
	 */
	HEALTH_CHECK_SUCCESS(HttpStatus.OK, "OK", true);

	private final HttpStatus httpStatus;
	private final String message;
	private final boolean success;

	public int getHttpStatusCode() {
		return httpStatus.value();
	}
}