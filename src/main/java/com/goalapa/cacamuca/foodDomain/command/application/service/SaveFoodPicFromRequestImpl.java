package com.goalapa.cacamuca.foodDomain.command.application.service;

import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodPicEntity;
import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodPicRepository;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodPicFromRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SaveFoodPicFromRequestImpl implements SaveFoodPicFromRequest {

    private final FoodPicRepository foodPicRepository;


    public SaveFoodPicFromRequestImpl(FoodPicRepository foodPicRepository) {
        this.foodPicRepository = foodPicRepository;
    }

    @Override
    @Transactional
    public void saveFoodPicFromRequest(String url) {

        FoodPicEntity foodPic = new FoodPicEntity();
        foodPic.setFoodPicUrl(url);

        foodPicRepository.save(foodPic);

    }
}
