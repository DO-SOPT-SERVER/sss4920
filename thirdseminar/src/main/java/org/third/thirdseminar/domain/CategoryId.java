package org.third.thirdseminar.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode
public class CategoryId implements Serializable {

	private String categoryId;
}
