package com.server.dosopt.seminar.common.dto;

import com.server.dosopt.seminar.exception.CommonSuccess;
import com.server.dosopt.seminar.exception.CommonError;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonApiResponse<T> {

	private final int code;
	private final String status;
	private T success;



	public static CommonApiResponse success(CommonSuccess success) {
		return new CommonApiResponse<>(success.getHttpStatusCode(), success.getStatus());
	}

	public static <T> CommonApiResponse<T> success(CommonSuccess s, T success) {
		return new CommonApiResponse<T>(s.getHttpStatusCode(), s.getStatus(), success);
	}

	public static CommonApiResponse error(CommonError error) {
		return new CommonApiResponse<>(error.getHttpStatusCode(), error.getStatus());
	}

	public static <T> CommonApiResponse<T> error(CommonError error, T success) {
		return new CommonApiResponse<>(error.getHttpStatusCode(), error.getStatus(), success);
	}
}