package com.goalapa.cacamuca.foodDomain.command.domain.repository;

import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodPicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodPicRepository extends JpaRepository<FoodPicEntity, Integer> {
}
