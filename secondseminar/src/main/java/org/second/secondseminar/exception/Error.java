package org.second.secondseminar.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Error {

	/**
	 * 404 NOT FOUND
	 */
	USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾지 못했어요~")
	;

	private final HttpStatus httpStatus;
	private final String message;

	public int getErrorCode() {
		return httpStatus.value();
	}
}
