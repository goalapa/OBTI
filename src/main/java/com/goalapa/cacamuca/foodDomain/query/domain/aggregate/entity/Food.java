package com.goalapa.cacamuca.foodDomain.query.domain.aggregate.entity;


import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int foodNo;

    private String foodName;

    private double foodRate;

    private int foodPrice;

    private String country;

    private String foodType;

    @Override
    public String toString() {
        return "Food{" +
                "foodNo=" + foodNo +
                ", foodName='" + foodName + '\'' +
                ", foodRate=" + foodRate +
                ", foodPrice=" + foodPrice +
                ", country='" + country + '\'' +
                ", foodType='" + foodType + '\'' +
                '}';
    }
}
