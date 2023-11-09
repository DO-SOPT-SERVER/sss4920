package org.second.secondseminar.domain;

import org.springframework.stereotype.Service;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String nickname;
	private int age;

	@Embedded
	@Setter
	private SOPT sopt;

	@Builder
	public Member(String name, String nickname, int age, SOPT sopt) {
		this.name = name;
		this.nickname = nickname;
		this.age = age;
		this.sopt = sopt;
	}


}
