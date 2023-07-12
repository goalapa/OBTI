package com.goalapa.cacamuca.requestDomain.command.application.dto;

import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestCountry;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestFoodType;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestMemberNo;

import javax.persistence.Column;

public class RequestDTO {

    private RequestCountry country;
    private RequestFoodType foodType;
    private String requestedFood;
    private Integer requestPrice;
    private RequestMemberNo memberNo;
    private String requestContent;

    public RequestDTO() {}

    public RequestCountry getCountry() {
        return country;
    }

    public void setCountry(RequestCountry country) {
        this.country = country;
    }

    public RequestFoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(RequestFoodType foodType) {
        this.foodType = foodType;
    }

    public String getRequestedFood() {
        return requestedFood;
    }

    public void setRequestedFood(String requestedFood) {
        this.requestedFood = requestedFood;
    }

    public Integer getRequestPrice() {
        return requestPrice;
    }

    public void setRequestPrice(Integer requestPrice) {
        this.requestPrice = requestPrice;
    }

    public RequestMemberNo getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(RequestMemberNo memberNo) {
        this.memberNo = memberNo;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }
}