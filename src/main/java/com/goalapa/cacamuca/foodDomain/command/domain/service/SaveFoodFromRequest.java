package com.goalapa.cacamuca.foodDomain.command.domain.service;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.Food;

public interface SaveFoodFromRequest {

    void saveFoodFromRequest(FoodDTO food);
}
