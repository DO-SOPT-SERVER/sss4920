package org.second.secondseminar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.second.secondseminar.common.ApiResponse;
import org.second.secondseminar.domain.Member;
import org.second.secondseminar.domain.SOPT;
import org.second.secondseminar.dto.request.MemberCreateRequest;
import org.second.secondseminar.dto.request.MemberProfileUpdateRequest;
import org.second.secondseminar.dto.response.MemberResponse;
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
				() -> new EntityNotFoundException("id로 조회했는데 없는거같은데요..?ㅠ")
			);
		return MemberResponse.of(member);
	}

	public MemberResponse getByIdV2(Long memberId) {
		return MemberResponse.of(memberJpaRepository.findByIdOrThrow(memberId));
	}

	public List<MemberResponse> getMembers() {
		return memberJpaRepository.findAll()
			.stream()
			.map(MemberResponse::of)
			.collect(Collectors.toList());
	}

	@Transactional
	public String create(MemberCreateRequest request) {
		Member member = memberJpaRepository.save(Member.builder()
			.name(request.name())
			.nickname(request.nickname())
			.age(request.age())
			.sopt(request.sopt())
			.build());
		return member.getId().toString();
	}
	//
	@Transactional
	public Member updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
		Member member = memberJpaRepository.findByIdOrThrow(memberId);
		member.setSopt(new SOPT(request.generation(), request.part()));
		return member;
	}

	@Transactional
	public void deleteMember(Long memberId) {
		Member member = memberJpaRepository.findByIdOrThrow(memberId);
		memberJpaRepository.delete(member);
	}
	private Member findById(Long memberId) {
		return memberJpaRepository.findById(memberId).orElseThrow(
			() -> new EntityNotFoundException("존재하지 않는 회원입니다."));
	}
}