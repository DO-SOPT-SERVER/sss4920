package org.third.thirdseminar.infrastructure;

import org.third.thirdseminar.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}