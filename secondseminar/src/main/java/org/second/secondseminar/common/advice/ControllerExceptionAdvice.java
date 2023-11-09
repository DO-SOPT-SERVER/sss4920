package org.second.secondseminar.common.advice;

import org.second.secondseminar.common.ApiResponse;
import org.second.secondseminar.exception.model.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@Component
@NoArgsConstructor
public class ControllerExceptionAdvice {
	/**
	 * custom error
	 */
	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<ApiResponse> handleSoptException(CustomException e) {
		return ResponseEntity.status(e.getHttpStatus())
			.body(ApiResponse.error(e.getError(), e.getMessage()));
	}
}
