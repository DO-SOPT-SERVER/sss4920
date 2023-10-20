package org.second.secondseminar.dto.response;

import org.second.secondseminar.domain.Member;
import org.second.secondseminar.domain.SOPT;

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