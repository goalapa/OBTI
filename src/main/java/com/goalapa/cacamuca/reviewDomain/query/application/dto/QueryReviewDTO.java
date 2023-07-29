package com.goalapa.cacamuca.reviewDomain.query.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class QueryReviewDTO {
    private String country;
    private String foodType;
    private int foodNo;
    private String foodName;
    private int reviewNo;
    private String reviewContent;
    private String reviewDate;
    private double reviewRate;
    private Integer memberNo;

    private String reviewKeyword;
    private int reviewPrice;
    private String reviewLink;
    private Integer likeCnt;
    private Integer reportCnt;

    public QueryReviewDTO() {
    }

    public QueryReviewDTO(int reviewNo, String reviewContent, String country, String foodType, String foodName, String reviewDate, double reviewRate, Integer memberNo, Integer foodNo, String reviewKeyword, int reviewPrice, String reviewLink, Integer likeCnt, Integer reportCnt) {
        this.reviewNo = reviewNo;
        this.reviewContent = reviewContent;
        this.country = country;
        this.foodType = foodType;
        this.foodName = foodName;
        this.reviewDate = reviewDate;
        this.reviewRate = reviewRate;
        this.memberNo = memberNo;
        this.reviewKeyword = reviewKeyword;
        this.reviewPrice = reviewPrice;
        this.reviewLink = reviewLink;
        this.likeCnt = likeCnt;
        this.reportCnt = reportCnt;
    }

    public QueryReviewDTO(int reviewPrice) {
        this.reviewPrice = reviewPrice;
    }


    public Integer getReportCnt() {
        return reportCnt;
    }

    public void setReportCnt(Integer reportCnt) {
        this.reportCnt = reportCnt;
    }

    public int getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(int foodNo) {
        this.foodNo = foodNo;
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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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


    public String getReviewKeyword() {
        return reviewKeyword;
    }

    public void setReviewKeyword(String reviewKeyword) {
        this.reviewKeyword = reviewKeyword;
    }

    public int getReviewPrice() {
        return reviewPrice;
    }

    public void setReviewPrice(int reviewPrice) {
        this.reviewPrice = reviewPrice;
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
}
