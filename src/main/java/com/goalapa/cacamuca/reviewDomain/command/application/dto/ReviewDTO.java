package com.goalapa.cacamuca.reviewDomain.command.application.dto;

import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


public class ReviewDTO {

    private String country;
    private String foodType;
    private String foodName;
    private int reviewNo;
    private String reviewContent;
    private String reviewDate;
    private double reviewRate;
    private Integer memberNo;
    private Integer foodNo;
    private String reviewKeyword;
    private int reviewPrice;
    private String reviewLink;
    private Integer likeCnt;

    public ReviewDTO(String country, String foodType, int reviewNo, String foodName, String reviewContent, String reviewDate, double reviewRate, Integer memberNo, Integer foodNo, String reviewKeyword, int reviewPrice, String reviewLink, Integer likeCnt) {
        this.country = country;
        this.foodType = foodType;
        this.reviewNo = reviewNo;
        this.foodName = foodName;
        this.reviewContent = reviewContent;
        this.reviewDate = reviewDate;
        this.reviewRate = reviewRate;
        this.memberNo = memberNo;
        this.foodNo = foodNo;
        this.reviewKeyword = reviewKeyword;
        this.reviewPrice = reviewPrice;
        this.reviewLink = reviewLink;
        this.likeCnt = likeCnt;
    }

    public ReviewDTO() {
    }

    public String getFoodType() {
        return foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getReviewPrice() {
        return reviewPrice;
    }

    public void setReviewPrice(int reviewPrice) {
        this.reviewPrice = reviewPrice;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    public double getReviewRate() {
        return reviewRate;
    }

    public void setReviewRate(double reviewRate) {
        this.reviewRate = reviewRate;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Integer memberNo) {
        this.memberNo = memberNo;
    }

    public Integer getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(Integer foodNo) {
        this.foodNo = foodNo;
    }

    public String getReviewKeyword() {
        return reviewKeyword;
    }

    public void setReviewKeyword(String reviewKeyword) {
        this.reviewKeyword = reviewKeyword;
    }



    public String getReviewLink() {
        return reviewLink;
    }

    public void setReviewLink(String reviewLink) {
        this.reviewLink = reviewLink;
    }

    public Integer getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(Integer likeCnt) {
        this.likeCnt = likeCnt;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "reviewNo=" + reviewNo +
                ", reviewContent='" + reviewContent + '\'' +
                ", reviewDate=" + reviewDate +
                ", reviewRate=" + reviewRate +
                ", memberNo=" + memberNo +
                ", foodNo=" + foodNo +
                ", reviewKeyword='" + reviewKeyword + '\'' +
                ", reviewPrice='" + reviewPrice + '\'' +
                ", reviewLink='" + reviewLink + '\'' +
                ", likeCnt=" + likeCnt +
                '}';
    }
}
