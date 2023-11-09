package org.second.secondseminar.infrastructure;

import org.second.secondseminar.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}