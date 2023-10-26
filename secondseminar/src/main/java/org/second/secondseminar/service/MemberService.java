package org.second.secondseminar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.second.secondseminar.domain.Member;
import org.second.secondseminar.domain.SOPT;
import org.second.secondseminar.dto.request.MemberCreateRequest;
import org.second.secondseminar.dto.request.MemberProfileUpdateRequest;
import org.second.secondseminar.dto.response.MemberDeleteResponse;
import org.second.secondseminar.dto.response.MemberResponse;
import org.second.secondseminar.exception.Error;
import org.second.secondseminar.exception.model.NotFoundException;
import org.second.secondseminar.infrastructure.MemberJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

	private final MemberJpaRepository memberJpaRepository;

	public MemberResponse getById(Long memberId) {
		Member member = memberJpaRepository.findById(memberId).orElseThrow(
			()->new NotFoundException(Error.USER_NOT_FOUND, Error.USER_NOT_FOUND.getMessage())
		);
		return MemberResponse.of(member);
	}

	// public MemberResponse getByIdV2(Long memberId) {
	// 	return MemberResponse.of(memberJpaRepository.findByIdOrThrow(memberId));
	// }

	public List<MemberResponse> getMembers() {
		return memberJpaRepository.findAll()
			.stream()
			.map(MemberResponse::of)
			.collect(Collectors.toList());
	}

	@Transactional
	public MemberResponse create(MemberCreateRequest request) {
		Member member = memberJpaRepository.save(Member.builder()
			.name(request.name())
			.nickname(request.nickname())
			.age(request.age())
			.sopt(request.sopt())
			.build());
		return MemberResponse.of(member);
	}
	//
	@Transactional
	public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
		Member member = memberJpaRepository.findByIdOrThrow(memberId);
		member.setSopt(new SOPT(request.generation(), request.part()));
	}

	@Transactional
	public MemberDeleteResponse deleteMember(Long memberId) {
		Member member = memberJpaRepository.findByIdOrThrow(memberId);
		memberJpaRepository.delete(member);
		return MemberDeleteResponse.of(memberId);
	}
	// private Member findById(Long memberId) {
	// 	return memberJpaRepository.findById(memberId).orElseThrow(
	// 		() -> new EntityNotFoundException("존재하지 않는 회원입니다."));
	// }
}