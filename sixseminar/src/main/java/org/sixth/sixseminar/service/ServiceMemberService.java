package org.sixth.sixseminar.service;

import org.sixth.sixseminar.controller.dto.request.servicemember.ServiceMemberRequest;
import org.sixth.sixseminar.controller.dto.response.MemberSignInResponse;
import org.sixth.sixseminar.domain.ServiceMember;
import org.sixth.sixseminar.infrastructure.ServiceMemberJpaRepository;
import org.sixth.sixseminar.security.JwtTokenProvider;
import org.sixth.sixseminar.security.UserAuthentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceMemberService {

	private final ServiceMemberJpaRepository serviceMemberJpaRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtTokenProvider jwtTokenProvider;

	@Transactional
	public String create(ServiceMemberRequest request) {
		System.out.println("하이");
		ServiceMember serviceMember = ServiceMember.builder()
			.nickname(request.nickname())
			.password(passwordEncoder.encode(request.password()))
			.build();
		serviceMemberJpaRepository.save(serviceMember);
		return serviceMember.getId().toString();
	}

	public MemberSignInResponse signIn(ServiceMemberRequest request) {
		ServiceMember serviceMember = serviceMemberJpaRepository.findByNickname(request.nickname())
			.orElseThrow(() -> new RuntimeException("해당하는 회원이 없습니다."));
		UserAuthentication userAuthentication = new UserAuthentication(serviceMember.getId(), null, null);

		if (!passwordEncoder.matches(request.password(), serviceMember.getPassword())) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		return MemberSignInResponse.of(jwtTokenProvider.generateToken(userAuthentication));
	}

}
