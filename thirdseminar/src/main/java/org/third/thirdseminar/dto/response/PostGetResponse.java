package org.third.thirdseminar.dto.response;

import org.third.thirdseminar.domain.Category;
import org.third.thirdseminar.domain.Post;

public record PostGetResponse(
	Long id,
	String title,
	String content,
	String category
) {
	public static PostGetResponse of(Post post, Category category) {
		return new PostGetResponse(
			post.getPostId(),
			post.getTitle(),
			post.getContent(),
			category.getContent()
		);
	}
}
