package org.sixth.sixseminar.controller;

import java.net.URI;
import java.security.Principal;

import org.sixth.sixseminar.common.ApiResponse;
import org.sixth.sixseminar.controller.dto.request.post.PostCreateRequest;
import org.sixth.sixseminar.exception.Success;
import org.sixth.sixseminar.service.PostServiceV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v2/posts")
@RequiredArgsConstructor
public class PostControllerV2 {

	private static final String CUSTOM_AUTH_ID = "X-Auth-Id";
	private final PostServiceV2 postService;

	@PostMapping
	public ApiResponse createPostV2(@RequestPart final MultipartFile image,
		final PostCreateRequest request,
		final Principal principal) {
		postService.createV2(request, image, Long.valueOf(principal.getName()));
		return ApiResponse.success(Success.CREATE_FEED_SUCCESS);
	}

	@DeleteMapping("{postId}")
	public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
		postService.deleteByIdV2(postId);
		return ResponseEntity.noContent().build();
	}
}
