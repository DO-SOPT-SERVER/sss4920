package com.server.dosopt.seminar.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CommonError {


	/**
	 * 406 Not Acceptable
	 */
	ALREADY_EXIST_USER_EXCEPTION(HttpStatus.NOT_ACCEPTABLE, "Getter가 빠진건 아닐까요?");


	private final HttpStatus httpStatus;
	private final String message;

	public int getHttpStatusCode() {
		return httpStatus.value();
	}
}
