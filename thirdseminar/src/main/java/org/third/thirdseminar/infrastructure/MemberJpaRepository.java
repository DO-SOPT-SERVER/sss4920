package org.third.thirdseminar.infrastructure;

import java.util.Optional;

import org.third.thirdseminar.domain.Member;
import org.third.thirdseminar.exception.Error;
import org.third.thirdseminar.exception.model.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
	Optional<Member> findByNickname(String nickname);
	default Member findByIdOrThrow(Long id) {
		return findById(id).orElseThrow(
			() -> new NotFoundException(Error.USER_NOT_FOUND, Error.USER_NOT_FOUND.getMessage()));
	}
	default Member findByNicknameOrThrow(String nickname) {
		return findByNickname(nickname).orElseThrow(
			() -> new NotFoundException(Error.USER_NOT_FOUND, Error.USER_NOT_FOUND.getMessage()));
	}
}
