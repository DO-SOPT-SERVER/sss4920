package org.third.thirdseminar.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.third.thirdseminar.domain.Category;

public interface CategoryJpaRepository extends JpaRepository<Category, Short> {
}
