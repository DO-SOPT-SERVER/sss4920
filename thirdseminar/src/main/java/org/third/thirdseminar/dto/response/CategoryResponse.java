package org.third.thirdseminar.dto.response;

import org.third.thirdseminar.domain.Category;

public record CategoryResponse(
	String content
) {
	public static CategoryResponse of(Category category){return new CategoryResponse(category.getContent());}
}
