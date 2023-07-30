package com.goalapa.cacamuca.categoryDomain.query.infrastructure.repository;

import com.goalapa.cacamuca.categoryDomain.query.domain.aggregate.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryCategoryRepository extends JpaRepository<Category, Integer> {


}
