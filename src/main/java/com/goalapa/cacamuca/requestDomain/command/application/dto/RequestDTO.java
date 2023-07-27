package com.goalapa.cacamuca.requestDomain.command.application.dto;

import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestCountry;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestFoodType;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestMemberNo;

import javax.persistence.Column;

import static java.lang.Integer.parseInt;

public class RequestDTO {

    private int requestNo;
    private String requestCountry;
    private String requestFoodType;
    private String requestFood;
    private int requestPrice;
    private int requestMemberNo;
    private String requestContent;

    public RequestDTO() {}

    public RequestDTO(int requestNo, String requestCountry, String requestFoodType, String requestFood, int requestPrice, String requestContent) {
        this.requestNo = requestNo;
        this.requestCountry = requestCountry;
        this.requestFoodType = requestFoodType;
        this.requestFood = requestFood;
        this.requestPrice = requestPrice;
        this.requestContent = requestContent;
    }

    public RequestDTO(String requestCountry, String requestFoodType, String requestFood, int requestPrice, int requestMemberNo, String requestContent) {
        this.requestCountry = requestCountry;
        this.requestFoodType = requestFoodType;
        this.requestFood = requestFood;
        this.requestPrice = requestPrice;
        this.requestMemberNo = requestMemberNo;
        this.requestContent = requestContent;
    }

    public int getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(int requestNo) {
        this.requestNo = requestNo;
    }

    public void setRequestPrice(int requestPrice) {
        this.requestPrice = requestPrice;
    }

    public String getRequestCountry() {
        return requestCountry;
    }

    public void setRequestCountry(String requestCountry) {
        this.requestCountry = requestCountry;
    }

    public String getRequestFoodType() {
        return requestFoodType;
    }

    public void setRequestFoodType(String requestFoodType) {
        this.requestFoodType = requestFoodType;
    }

    public String getRequestFood() {
        return requestFood;
    }

    public void setRequestFood(String requestedFood) {
        this.requestFood = requestedFood;
    }

    public Integer getRequestPrice() {
        return requestPrice;
    }

    public void setRequestPrice(Integer requestPrice) {
        this.requestPrice = requestPrice;
    }

    public int getRequestMemberNo() {
        return requestMemberNo;
    }

    public void setRequestMemberNo(int requestMemberNo) {
        this.requestMemberNo = requestMemberNo;
    }

    public String getRequestContent() {
        return requestContent;
    }

    public void setRequestContent(String requestContent) {
        this.requestContent = requestContent;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "requestCountry=" + requestCountry +
                ", requestFoodType=" + requestFoodType +
                ", requestedFood='" + requestFood + '\'' +
                ", requestPrice=" + requestPrice +
                ", requestMemberNo=" + requestMemberNo +
                ", requestContent='" + requestContent + '\'' +
                '}';
    }
}