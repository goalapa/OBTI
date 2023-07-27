package com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FoodTypeVO {

    @Column(name = "food_type")
    private String foodType;

    public FoodTypeVO(String foodType) { this.foodType = foodType; }

    public FoodTypeVO() {}

    @Override
    public String toString() {
        return ""+foodType;
    }
}
