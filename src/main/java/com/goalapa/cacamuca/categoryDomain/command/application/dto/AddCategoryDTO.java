package com.goalapa.cacamuca.categoryDomain.command.application.dto;


public class AddCategoryDTO {

    private String categoryName;
    private String subCategoryName;

    public AddCategoryDTO() {}

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    @Override
    public String toString() {
        return "AddCategoryDTO{" +
                "categoryName='" + categoryName + '\'' +
                ", subCategoryName='" + subCategoryName + '\'' +
                '}';
    }

}
