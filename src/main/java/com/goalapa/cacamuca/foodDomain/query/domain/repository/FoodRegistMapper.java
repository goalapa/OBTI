package com.goalapa.cacamuca.foodDomain.query.domain.repository;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodPicDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodEntity;
import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface FoodRegistMapper {

    List<Food> findFoodsRegist(Pageable pageable);

    Integer countFoodRegistList();

    List<FoodPicDTO> findAllFoodPic();
}
