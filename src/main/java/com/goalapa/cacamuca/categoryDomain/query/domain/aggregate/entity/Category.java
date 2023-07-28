package com.goalapa.cacamuca.categoryDomain.query.domain.aggregate.entity;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodNo;
    private String country;
    private String foodType;

    @Override
    public String toString() {
        return "Category{" +
                "foodNo=" + foodNo +
                ", country='" + country + '\'' +
                ", foodType='" + foodType + '\'' +
                '}';
    }
}
