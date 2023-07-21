
package com.goalapa.cacamuca.foodDomain.command.application.dto;

import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.Country;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.FoodType;

public class FoodDTO {

    private int foodNo;
    private String foodName;
    private double foodRate;
    private int foodPrice;
    private String country;
    private String foodType;

    public FoodDTO() {}

    public FoodDTO(String foodName, double foodRate, int foodPrice, String country, String foodType) {
        this.foodName = foodName;
        this.foodRate = foodRate;
        this.foodPrice = foodPrice;
        this.country = country;
        this.foodType = foodType;
    }

    public int getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(int foodNo) {
        this.foodNo = foodNo;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodRate() {
        return foodRate;
    }

    public void setFoodRate(double foodRate) {
        this.foodRate = foodRate;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
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

    @Override
    public String toString() {
        return "FoodDTO{" +
                "foodNo=" + foodNo +
                ", foodName='" + foodName + '\'' +
                ", foodRate=" + foodRate +
                ", foodPrice=" + foodPrice +
                ", country=" + country +
                ", foodType=" + foodType +
                '}';
    }
}
