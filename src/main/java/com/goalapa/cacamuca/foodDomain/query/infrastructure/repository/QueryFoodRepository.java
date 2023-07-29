package com.goalapa.cacamuca.foodDomain.query.infrastructure.repository;

import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryFoodRepository extends JpaRepository<Food, Integer> {
}
