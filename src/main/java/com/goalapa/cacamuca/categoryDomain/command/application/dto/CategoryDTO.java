package com.goalapa.cacamuca.categoryDomain.command.application.dto;

public class CategoryDTO {

    private Integer categoryNo;
    private String country;
    private String foodType;

    public CategoryDTO() {}

    public CategoryDTO(Integer categoryNo, String country, String foodType) {
        this.categoryNo = categoryNo;
        this.country = country;
        this.foodType = foodType;
    }

    public Integer getCategoryNo() { return categoryNo; }

    public void setCategoryNo(Integer categoryNo) { this.categoryNo = categoryNo; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getFoodType() { return foodType; }

    public void setFoodType(String foodType) { this.foodType = foodType; }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryNo=" + categoryNo +
                ", country='" + country + '\'' +
                ", foodType='" + foodType + '\'' +
                '}';
    }
}
