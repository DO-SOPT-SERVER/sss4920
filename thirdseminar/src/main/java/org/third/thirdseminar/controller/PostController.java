package org.third.thirdseminar.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.third.thirdseminar.dto.request.post.PostCreateRequest;
import org.third.thirdseminar.dto.response.PostGetResponse;
import org.third.thirdseminar.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
	private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
	private final PostService postService;

	@GetMapping("{postId}")
	public ResponseEntity<PostGetResponse> getPostById(@PathVariable Long postId) {
		return ResponseEntity.ok(postService.getById(postId));
	}

	@GetMapping
	public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
		return ResponseEntity.ok(postService.getPosts(memberId));
	}


	@PostMapping
	public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
		@RequestBody PostCreateRequest request) {
		URI location = URI.create("/api/post/" + postService.create(request, memberId));
		return ResponseEntity.created(location).build();
	}
}
