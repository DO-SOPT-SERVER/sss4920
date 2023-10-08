package com.server.dosopt.seminar.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HealthCheckResponseDto {
	private boolean success = true;

	public static HealthCheckResponseDto of (boolean success){
		return new HealthCheckResponseDto(success);
	}


}
