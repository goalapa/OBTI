package com.goalapa.cacamuca.foodDomain.command.domain.service;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;

public interface SaveFoodFromRequest {

    void saveFoodFromRequest(FoodDTO food);
}
