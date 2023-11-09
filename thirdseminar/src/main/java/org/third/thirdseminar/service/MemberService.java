package org.third.thirdseminar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.third.thirdseminar.domain.Member;
import org.third.thirdseminar.domain.SOPT;
import org.third.thirdseminar.dto.request.member.MemberCreateRequest;
import org.third.thirdseminar.dto.request.member.MemberProfileUpdateRequest;
import org.third.thirdseminar.dto.response.MemberDeleteResponse;
import org.third.thirdseminar.dto.response.MemberResponse;
import org.third.thirdseminar.infrastructure.MemberJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

	private final MemberJpaRepository memberJpaRepository;

	public MemberResponse getById(Long memberId) {
		return MemberResponse.of(findMemberById(memberId));
	}

	public List<MemberResponse> getMembers() {
		return memberJpaRepository.findAll()
			.stream()
			.map(MemberResponse::of)
			.collect(Collectors.toList());
	}

	@Transactional
	public MemberResponse create(MemberCreateRequest request) {
		return MemberResponse.of(memberJpaRepository.save(Member.builder()
			.name(request.name())
			.nickname(request.nickname())
			.age(request.age())
			.sopt(request.sopt())
			.build()));
	}

	//
	@Transactional
	public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
		Member member = findMemberById(memberId);
		member.setSopt(new SOPT(request.generation(), request.part()));
	}

	@Transactional
	public MemberDeleteResponse deleteMember(Long memberId) {
		memberJpaRepository.delete(findMemberById(memberId));
		return MemberDeleteResponse.of(memberId);
	}

	//private method로 중복 코드 빼주기
	private Member findMemberById(Long memberId) {
		Member member = memberJpaRepository.findByIdOrThrow(memberId);
		return member;
	}
}