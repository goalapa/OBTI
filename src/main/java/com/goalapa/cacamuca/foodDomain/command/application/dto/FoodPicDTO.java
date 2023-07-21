package com.goalapa.cacamuca.foodDomain.command.application.dto;

public class FoodPicDTO {

    private int foodNo;
    private String foodPicUrl;

    public FoodPicDTO() {}

    public int getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(int foodNo) {
        this.foodNo = foodNo;
    }

    public String getFoodPicUrl() {
        return foodPicUrl;
    }

    public void setFoodPicUrl(String foodPicUrl) {
        this.foodPicUrl = foodPicUrl;
    }

    @Override
    public String toString() {
        return "FoodPicDTO{" +
                "foodNo=" + foodNo +
                ", foodPicUrl='" + foodPicUrl + '\'' +
                '}';
    }

}
