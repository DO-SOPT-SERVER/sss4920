package org.second.secondseminar.infrastructure;

import java.util.Optional;

import org.second.secondseminar.domain.Member;
import org.second.secondseminar.exception.Error;
import org.second.secondseminar.exception.model.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.EntityNotFoundException;

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
