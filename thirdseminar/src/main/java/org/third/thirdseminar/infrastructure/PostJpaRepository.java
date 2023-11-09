package org.third.thirdseminar.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.third.thirdseminar.domain.Member;
import org.third.thirdseminar.domain.Post;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
	List<Post> findAllByMemberId(Long memberId);
	List<Post> findAllByMember(Member member);
}
