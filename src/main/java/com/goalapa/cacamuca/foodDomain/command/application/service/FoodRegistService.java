package com.goalapa.cacamuca.foodDomain.command.application.service;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodEntity;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodPicEntity;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.CountryVO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.FoodTypeVO;
import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodPicRepository;
import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FoodRegistService {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private FoodPicRepository foodPicRepository;

    public FoodRegistService(FoodRepository foodRepository, FoodPicRepository foodPicRepository) {
        this.foodRepository = foodRepository;
        this.foodPicRepository = foodPicRepository;
    }

    //식품 등록
    @Transactional
    public void saveFood(FoodDTO foodDTO, @RequestParam MultipartFile registPic) throws IOException {


        FoodEntity food = new FoodEntity();
        FoodPicEntity foodPic = new FoodPicEntity();

        food.setFoodNo(foodDTO.getFoodNo());
        food.setFoodName(foodDTO.getFoodName());
        food.setFoodRate(foodDTO.getFoodRate());
        food.setFoodPrice(foodDTO.getFoodPrice());
        food.setCountryVO(new CountryVO());
        food.setFoodTypeVO(new FoodTypeVO());
        foodPic.setFoodNo((foodPic.getFoodNo()));
        foodPic.setFoodPicUrl((foodPic.getFoodPicUrl()));


        String root = "C:\\app-file";
        String filePath = root + "/uploadFiles";

        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String originFileName = registPic.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String saveName = UUID.randomUUID().toString().replaceAll("-", "") + ext;


        try {
            registPic.transferTo(new File(filePath + "/"));
        } catch (IOException e) {
            new File(filePath + "/").delete();
        }

        foodRepository.save(food);
    }

    //식품 삭제
    @Transactional
    public void deleteFood(int foodNo) {
        foodRepository.deleteById(foodNo);
    }

    @Transactional
    public void deleteFoodPic(int foodNo) {
        foodPicRepository.deleteById(foodNo);
    }

}
