package org.sixth.sixseminar.controller.dto.response;

public record MemberSignInResponse(String jwtToken) {
	public static MemberSignInResponse of(String jwtToken){
		return new MemberSignInResponse(jwtToken);
	}
}
