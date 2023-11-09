package org.third.thirdseminar.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.third.thirdseminar.domain.Category;
import org.third.thirdseminar.domain.Member;
import org.third.thirdseminar.domain.Post;
import org.third.thirdseminar.dto.request.post.PostCreateRequest;
import org.third.thirdseminar.dto.request.post.PostUpdateRequest;
import org.third.thirdseminar.dto.response.PostGetResponse;
import org.third.thirdseminar.infrastructure.MemberJpaRepository;
import org.third.thirdseminar.infrastructure.PostJpaRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

	private final PostJpaRepository postJpaRepository;
	private final MemberJpaRepository memberJpaRepository;
	private final CategoryService categoryService;
	@Transactional
	public String create(PostCreateRequest request, Long memberId) {
		Member member = memberJpaRepository.findByIdOrThrow(memberId);
		Post post = postJpaRepository.save(
			Post.builder()
				.member(member)
				.title(request.title())
				.content(request.content()).build());

		return post.getPostId().toString();
	}


	@Transactional
	public void editContent(Long postId, PostUpdateRequest request) {
		Post post = postJpaRepository.findById(postId)
			.orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
		post.updateContent(request.content());
	}

	@Transactional
	public void deleteById(Long postId) {
		Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
		postJpaRepository.delete(post);
	}
	public List<PostGetResponse> getPosts(Long memberId) {
		return postJpaRepository.findAllByMemberId(memberId)
			.stream()
			.map(post -> PostGetResponse.of(post, getCategoryByPost(post)))
			.toList();
	}

	public PostGetResponse getById(Long postId) {
		Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
		return PostGetResponse.of(post,getCategoryByPost(post));
	}

	private Category getCategoryByPost(Post post) {
		return categoryService.getByCategoryId(post.getCategoryId());
	}
}
