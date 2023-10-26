package org.second.secondseminar.dto.request;


import org.second.secondseminar.domain.SOPT;


public record MemberCreateRequest(String name, String nickname, int age, SOPT sopt) {
}