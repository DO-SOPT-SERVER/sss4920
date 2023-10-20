package org.second.secondseminar.infrastructure;

import org.second.secondseminar.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.EntityNotFoundException;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
	default Member findByIdOrThrow(Long id) {
		return findById(id).orElseThrow(
			() -> new EntityNotFoundException("존재하지 않는 회원입니다."));
	}
}
