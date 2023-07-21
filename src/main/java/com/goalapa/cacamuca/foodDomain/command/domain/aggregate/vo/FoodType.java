package com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FoodType {

    @Column(name = "food_type")
    private String foodType;

    protected FoodType() {}

    public FoodType(String foodType) {
        this.foodType = foodType;
    }
}
