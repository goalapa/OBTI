package com.goalapa.cacamuca.statDomain.query.infrastructure.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatMapper {
    Integer countLikes(int foodNo);
    int countReviews(int foodNo);
    float calculateFoodRate(int foodNo);
    int memberAgeGroup(int foodNo);
    String memberGender(int foodNo);
}
