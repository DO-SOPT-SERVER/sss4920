package org.second.secondseminar.exception;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Success {

	/**
	 * 201 CREATED
	 */
	CREATE_SUCCESS(HttpStatus.CREATED, "유저 생성 완-벽"),

	/**
	 * 200 OK
	 */
	UPDATE_SUCCESS(HttpStatus.OK, "유저 수정 성공~"),

	DELETE_SUCCESS(HttpStatus.OK, "유저 삭제 성공~")

	;

	private final HttpStatus httpStatus;
	private final String message;

	public int getHttpStatusCode(){
		return httpStatus.value();
	}

}
