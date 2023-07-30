package com.goalapa.cacamuca.foodDomain.command.application.service;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodEntity;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.CountryVO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.FoodTypeVO;
import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodRepository;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodFromRequest;
import com.goalapa.cacamuca.requestDomain.command.domain.repository.RequestRepository;
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

        CountryVO country = new CountryVO(foodDTO.getCountry());
        FoodTypeVO foodType = new FoodTypeVO(foodDTO.getFoodType());

        FoodEntity food = new FoodEntity();
        food.setFoodName(foodDTO.getFoodName());
        food.setFoodPrice(foodDTO.getFoodPrice());
        food.setCountryVO(country);
        food.setFoodTypeVO(foodType);

        System.out.println("food = " + food);

        foodRepository.save(food);
    }
}
