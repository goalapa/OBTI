package com.goalapa.cacamuca.foodDomain.command.domain.repository;

import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {
    FoodEntity findByFoodNameAndCountryVO_Country(String foodName, String country);
}