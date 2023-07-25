package com.goalapa.cacamuca.categoryDomain.command.application.dto;


public class AddCategoryDTO {

    private String country;
    private String foodType;

    public AddCategoryDTO() {}

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
        return "AddCategoryDTO{" +
                "categoryName='" + country + '\'' +
                ", subCategoryName='" + foodType + '\'' +
                '}';
    }

}
