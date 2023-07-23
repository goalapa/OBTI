package com.goalapa.cacamuca.foodDomain.command.application.service;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodPicDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodPic;
import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodPicRepository;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodPicFromRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

        FoodPic foodPic = new FoodPic();
        foodPic.setFoodPicUrl(url);

        foodPicRepository.save(foodPic);

    }
}
