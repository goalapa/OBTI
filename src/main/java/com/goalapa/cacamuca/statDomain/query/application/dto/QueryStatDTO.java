package com.goalapa.cacamuca.statDomain.query.application.dto;

import java.time.LocalDate;

public class QueryStatDTO {
    private Integer statNo;
    private LocalDate updateDate;
    private Integer foodNo;
    private String foodName;
    private Integer reviewCnt;
    private float foodRate;
    private Integer likeCnt;
    private Integer memberAgeGroup;
    private String memberGender;
    private String country;
    private String foodImageUrl;

    public QueryStatDTO() {}

    public QueryStatDTO(Integer statNo, LocalDate updateDate, Integer foodNo, String foodName, Integer reviewCnt, float foodRate, Integer likeCnt, Integer memberAgeGroup, String memberGender, String country, String foodImageUrl) {
        this.statNo = statNo;
        this.updateDate = updateDate;
        this.foodNo = foodNo;
        this.foodName = foodName;
        this.reviewCnt = reviewCnt;
        this.foodRate = foodRate;
        this.likeCnt = likeCnt;
        this.memberAgeGroup = memberAgeGroup;
        this.memberGender = memberGender;
        this.country = country;
        this.foodImageUrl = foodImageUrl;
    }

    public QueryStatDTO(int foodRate) {
        this.foodRate = foodRate;
    }

    public Integer getStatNo() {
        return statNo;
    }

    public void setStatNo(Integer statNo) {
        this.statNo = statNo;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(Integer foodNo) {
        this.foodNo = foodNo;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getReviewCnt() {
        return reviewCnt;
    }

    public void setReviewCnt(Integer reviewCnt) {
        this.reviewCnt = reviewCnt;
    }

    public float getFoodRate() {
        return foodRate;
    }

    public void setFoodRate(float foodRate) {
        this.foodRate = foodRate;
    }

    public Integer getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(Integer likeCnt) {
        this.likeCnt = likeCnt;
    }

    public Integer getMemberAgeGroup() {
        return memberAgeGroup;
    }

    public void setMemberAgeGroup(Integer memberAgeGroup) {
        this.memberAgeGroup = memberAgeGroup;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFoodImageUrl() {
        return foodImageUrl;
    }

    public void setFoodImageUrl(String foodImageUrl) {
        this.foodImageUrl = foodImageUrl;
    }

    @Override
    public String toString() {
        return "QueryStatDTO{" +
                "statNo=" + statNo +
                ", updateDate=" + updateDate +
                ", foodNo=" + foodNo +
                ", foodName='" + foodName + '\'' +
                ", reviewCnt=" + reviewCnt +
                ", foodRate=" + foodRate +
                ", likeCnt=" + likeCnt +
                ", memberAgeGroup=" + memberAgeGroup +
                ", memberGender='" + memberGender + '\'' +
                ", country='" + country + '\'' +
                ", foodImageUrl='" + foodImageUrl + '\'' +
                '}';
    }
}
