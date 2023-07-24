package com.goalapa.cacamuca.categoryDomain.command.application.dto;

public class UpdateCategoryDTO {

    private String country;
    private String foodType;
    private String replaceCountry;
    private String replaceFoodType;


    public UpdateCategoryDTO(String country, String foodType, String replaceCountry, String replaceFoodType) {
        this.country = country;
        this.foodType = foodType;
        this.replaceCountry = replaceCountry;
        this.replaceFoodType = replaceFoodType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFoodType() { return foodType; }
    public void setFoodType(String foodType) { this.foodType = foodType; }

    public String getReplaceCountry() {
        return replaceCountry;
    }

    public void setReplaceCountry(String replaceCountry) {
        this.replaceCountry = replaceCountry;
    }

    public String getReplaceFoodType() {
        return replaceFoodType;
    }

    public void setReplaceFoodType(String replaceFoodType) {
        this.replaceFoodType = replaceFoodType;
    }

    @Override
    public String toString() {
        return "UpdateCategoryDTO{" +
                "country='" + country + '\'' +
                ", foodType='" + foodType + '\'' +
                ", replaceCountry='" + replaceCountry + '\'' +
                ", replaceFoodType='" + replaceFoodType + '\'' +
                '}';
    }
}
