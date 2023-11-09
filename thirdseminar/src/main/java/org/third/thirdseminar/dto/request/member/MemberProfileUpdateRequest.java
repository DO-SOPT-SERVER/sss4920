package org.third.thirdseminar.dto.request.member;

import org.third.thirdseminar.domain.Part;

public record MemberProfileUpdateRequest(int generation, Part part) {
}
