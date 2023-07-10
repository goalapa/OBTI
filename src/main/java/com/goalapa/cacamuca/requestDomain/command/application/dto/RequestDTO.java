package com.goalapa.cacamuca.requestDomain.command.application.dto;

import javax.persistence.Column;

public class RequestDTO {

    private String country;
    private String foodType;
    private String requestedFood;
    private Integer requestPrice;
    private Integer memberNo;

    public RequestDTO() {}
    public RequestDTO(String country, String foodType, String requestedFood, Integer requestPrice, Integer memberNo, Integer categoryNo) {
        this.country = country;
        this.foodType = foodType;
        this.requestedFood = requestedFood;
        this.requestPrice = requestPrice;
        this.memberNo = memberNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
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

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "country='" + country + '\'' +
                ", foodType='" + foodType + '\'' +
                ", requestedFood='" + requestedFood + '\'' +
                ", requestPrice=" + requestPrice +
                ", memberNo=" + memberNo +
                '}';
    }
}