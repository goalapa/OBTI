package com.goalapa.cacamuca.foodDomain.command.ininfrastructure.repository;

import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
}
