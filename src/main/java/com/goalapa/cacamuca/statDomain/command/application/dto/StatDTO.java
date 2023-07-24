package com.goalapa.cacamuca.statDomain.command.application.dto;


import java.time.LocalDate;

public class StatDTO {

    private Integer statNo;
    private LocalDate updateDate;
    private Integer foodNo;
    private Integer reviewCnt;
    private float foodRate;
    private Integer likeCnt;
    private Integer memberAgeGroup;
    private String memberGender;

    public StatDTO() {}

    public StatDTO(Integer statNo, LocalDate updateDate, Integer foodNo, Integer reviewCnt, float foodRate, Integer likeCnt, Integer memberAgeGroup, String memberGender) {
        this.statNo = statNo;
        this.updateDate = updateDate;
        this.foodNo = foodNo;
        this.reviewCnt = reviewCnt;
        this.foodRate = foodRate;
        this.likeCnt = likeCnt;
        this.memberAgeGroup = memberAgeGroup;
        this.memberGender = memberGender;
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

    @Override
    public String toString() {
        return "StatDTO{" +
                "statNo=" + statNo +
                ", updateDate=" + updateDate +
                ", foodNo=" + foodNo +
                ", reviewCnt=" + reviewCnt +
                ", foodRate=" + foodRate +
                ", likeCnt=" + likeCnt +
                ", memberAgeGroup=" + memberAgeGroup +
                ", memberGender=" + memberGender +
                '}';
    }
}
