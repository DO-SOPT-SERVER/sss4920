package com.server.dosopt.seminar.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HealthCheckResponse {

	private boolean success;

	public static HealthCheckResponse of(boolean success){
		return new HealthCheckResponse(success);
	}
}
