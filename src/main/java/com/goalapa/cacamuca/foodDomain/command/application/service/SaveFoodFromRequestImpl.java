package com.goalapa.cacamuca.foodDomain.command.application.service;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.Food;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.Country;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.FoodType;
import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodRepository;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodFromRequest;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestCountry;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestFoodType;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestMemberNo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SaveFoodFromRequestImpl implements SaveFoodFromRequest {

    private final FoodRepository foodRepository;

    public SaveFoodFromRequestImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    @Transactional
    public void saveFoodFromRequest(FoodDTO foodDTO) {

        Country country = new Country(foodDTO.getCountry());
        FoodType foodType = new FoodType(foodDTO.getFoodType());

        Food food = new Food();
        food.setFoodName(foodDTO.getFoodName());
        food.setFoodPrice(foodDTO.getFoodPrice());
        food.setCountry(country);
        food.setFoodType(foodType);

        System.out.println("food = " + food);

        foodRepository.save(food);
    }
}
