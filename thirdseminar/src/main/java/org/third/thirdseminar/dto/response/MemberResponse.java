package org.third.thirdseminar.dto.response;

import org.third.thirdseminar.domain.Member;
import org.third.thirdseminar.domain.SOPT;

public record MemberResponse(
	String name,
	String nickname,
	int age,
	SOPT soptInfo
) {
	public static MemberResponse of(Member member) {
		return new MemberResponse(
			member.getName(),
			member.getNickname(),
			member.getAge(),
			member.getSopt()
		);
	}
}