package com.goalapa.cacamuca.statDomain.command.application.service;

import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodEntity;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodPicEntity;
import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodPicRepository;
import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodRepository;
import com.goalapa.cacamuca.statDomain.command.application.dto.StatDTO;
import com.goalapa.cacamuca.statDomain.query.infrastructure.service.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@Configuration
public class StatScheduler {

    private final FoodRepository foodRepository;
    private final FoodPicRepository foodPicRepository;
    private final SaveStatServiceImpl saveStatServiceImpl;
    private final LikeCntService likeCntService;
    private final ReviewCntService reviewCntService;
    private final FoodRateService foodRateService;
    private final MemberAgeGroupService memberAgeGroupService;
    private final MemberGenderService memberGenderService;

    public StatScheduler(FoodRepository foodRepository, FoodPicRepository foodPicRepository, SaveStatServiceImpl saveStatServiceImpl, LikeCntService likeCntService, ReviewCntService reviewCntService, FoodRateService foodRateService, MemberAgeGroupService memberAgeGroupService, MemberGenderService memberGenderService) {
        this.foodRepository = foodRepository;
        this.foodPicRepository = foodPicRepository;
        this.saveStatServiceImpl = saveStatServiceImpl;
        this.likeCntService = likeCntService;
        this.reviewCntService = reviewCntService;
        this.foodRateService = foodRateService;
        this.memberAgeGroupService = memberAgeGroupService;
        this.memberGenderService = memberGenderService;
    }

//    @Scheduled(cron = "0 0 3 * * *")
    public void insertData() {

        List<FoodEntity> foods = foodRepository.findAll();

        for(FoodEntity food : foods) {
            int foodNo = food.getFoodNo();
            int reviewCnt = reviewCntService.countReviews(foodNo);

            Optional<FoodPicEntity> optionalFoodPic = foodPicRepository.findById(foodNo);
            FoodPicEntity foodPic = null;
            if(optionalFoodPic.isPresent()) foodPic = optionalFoodPic.get();

            if(reviewCnt == 0) {
                break;
            } else {
                String country = food.getCountryVO().toString();
                String foodName = food.getFoodName();
                Integer likeCnt = likeCntService.countLikes(foodNo);
                //int reviewCnt = reviewCntService.countReviews(foodNo);
                float foodRate = foodRateService.calculateFoodRate(foodNo);
                int memberAgeGroup = memberAgeGroupService.returnMemberAgeGroup(foodNo);
                String memberGender = memberGenderService.getPreferredMemberGender(foodNo);

                StatDTO statDTO = new StatDTO();
                statDTO.setUpdateDate(LocalDate.now());
                statDTO.setFoodNo(food.getFoodNo());
                statDTO.setFoodName(foodName);
                statDTO.setCountry(country);
                statDTO.setLikeCnt(likeCnt);
                statDTO.setReviewCnt(reviewCnt);
                statDTO.setFoodRate(foodRate);
                statDTO.setMemberAgeGroup(memberAgeGroup);
                statDTO.setMemberGender(memberGender);
                statDTO.setFoodeImageUrl(foodPic.getFoodPicUrl());

                saveStatServiceImpl.insertData(statDTO);
            }
        }


    }
}
