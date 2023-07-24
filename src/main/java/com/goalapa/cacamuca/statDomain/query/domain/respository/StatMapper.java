package com.goalapa.cacamuca.statDomain.query.domain.respository;

@org.apache.ibatis.annotations.Mapper
public interface StatMapper {
    int countLikes(int foodNo);
    int countReviews(int foodNo);
    float calculateFoodRate(int foodNo);
    int memberAgeGroup(int foodNo);
    String memberGender(int foodNo);
}
