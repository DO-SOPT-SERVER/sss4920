package com.server.dosopt.seminar.common.dto;

import com.server.dosopt.seminar.exception.CommonError;
import com.server.dosopt.seminar.exception.CommonSuccess;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonApiResponse<T> {

	private final int code;
	private final String message;
	private T data;

	public static CommonApiResponse success(CommonSuccess success) {
		return new CommonApiResponse<>(success.getHttpStatusCode(), success.getMessage());
	}

	public static <T> CommonApiResponse<T> success(CommonSuccess success, T data) {
		return new CommonApiResponse<T>(success.getHttpStatusCode(), success.getMessage(), data);
	}

	public static CommonApiResponse error(CommonError error) {
		return new CommonApiResponse<>(error.getHttpStatusCode(), error.getMessage());
	}

	public static CommonApiResponse error(CommonError error, String message) {
		return new CommonApiResponse<>(error.getHttpStatusCode(), message);
	}

}