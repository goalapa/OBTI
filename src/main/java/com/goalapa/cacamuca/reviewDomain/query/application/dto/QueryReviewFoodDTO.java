package com.goalapa.cacamuca.reviewDomain.query.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class QueryReviewFoodDTO {
    private int foodNo;
    private String foodName;
    private String country;
    private String foodType;
}
