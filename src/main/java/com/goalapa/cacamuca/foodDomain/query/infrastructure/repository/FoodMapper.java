package com.goalapa.cacamuca.foodDomain.query.infrastructure.repository;

import com.goalapa.cacamuca.foodDomain.query.application.dto.QueryFoodDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {

    List<QueryFoodDTO> findAllFood();
}
