package com.goalapa.cacamuca.foodDomain.query.domain.repository;

import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodEntity;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.CountryVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QueryFoodRepo extends JpaRepository<FoodEntity, Integer> {

    Page<FoodEntity> findByCountryVO(Pageable pageable, CountryVO country);

}
