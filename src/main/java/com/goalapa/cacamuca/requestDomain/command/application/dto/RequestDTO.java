package com.goalapa.cacamuca.requestDomain.command.application.dto;

import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestCountry;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestFoodType;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestMemberNo;

import javax.persistence.Column;

import static java.lang.Integer.parseInt;

public class RequestDTO {

    private String requestCountry;
    private String requestFoodType;
    private String requestedFood;
    private int requestPrice;
    private int requestMemberNo;
    private String requestContent;

    public RequestDTO() {}

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
                ", requestedFood='" + requestedFood + '\'' +
                ", requestPrice=" + requestPrice +
                ", requestMemberNo=" + requestMemberNo +
                ", requestContent='" + requestContent + '\'' +
                '}';
    }
}