package com.goalapa.cacamuca.categoryDomain.command.domain.repository;


import com.goalapa.cacamuca.categoryDomain.command.domain.aggregate.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    CategoryEntity findByCountryAndFoodType(String country, String foodType);


}
