package com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RequestFoodType {

    @Column(name = "request_food_type")
    private String requestFoodType;

    protected RequestFoodType() {}

    public RequestFoodType(String requestFoodType) {
        this.requestFoodType = requestFoodType;
    }

    public String getRequestFoodType() {
        return requestFoodType;
    }

    @Override
    public String toString() {
        return requestFoodType;
    }
}
