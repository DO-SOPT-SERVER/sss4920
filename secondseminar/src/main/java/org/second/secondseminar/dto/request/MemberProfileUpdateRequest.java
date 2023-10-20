package org.second.secondseminar.dto.request;

import org.second.secondseminar.domain.Part;

import lombok.Data;


public record MemberProfileUpdateRequest(int generation, Part part) {
}
