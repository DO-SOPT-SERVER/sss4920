package org.third.thirdseminar.dto.request.member;


import org.third.thirdseminar.domain.SOPT;

public record MemberCreateRequest(String name, String nickname, int age, SOPT sopt) {
}