package com.goalapa.cacamuca.requestDomain.query.application.dto;

public class FindRequestDTO {

    private int requestNo;

    private String requestCountry;
    private String requestFoodType;
    private String requestFood;
    private int requestPrice;
    private int requestMemberNo;
    private String requestContent;

    public FindRequestDTO() {}

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
        return "FindRequestDTO{" +
                "requestNo=" + requestNo +
                ", requestCountry='" + requestCountry + '\'' +
                ", requestFoodType='" + requestFoodType + '\'' +
                ", requestFood='" + requestFood + '\'' +
                ", requestPrice=" + requestPrice +
                ", requestMemberNo=" + requestMemberNo +
                ", requestContent='" + requestContent + '\'' +
                '}';
    }
}
