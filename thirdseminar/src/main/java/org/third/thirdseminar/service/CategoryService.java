package org.third.thirdseminar.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.third.thirdseminar.domain.Category;
import org.third.thirdseminar.domain.CategoryId;
import org.third.thirdseminar.dto.response.CategoryResponse;
import org.third.thirdseminar.infrastructure.CategoryJpaRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

	private final CategoryJpaRepository categoryJpaRepository;

	public Category getByCategoryId(CategoryId categoryId) {
		return categoryJpaRepository.findById(Short.valueOf(categoryId.getCategoryId())).orElseThrow(
			() -> new EntityNotFoundException("해당하는 카테고리가 없습니다."));
	}

	public CategoryResponse getById(Short id) {
		return CategoryResponse.of(categoryJpaRepository.findById(id).orElseThrow(
			() -> new EntityNotFoundException("해당하는 카테고리가 없습니다.")));
	}
}
