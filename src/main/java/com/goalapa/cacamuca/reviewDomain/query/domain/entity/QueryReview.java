package com.goalapa.cacamuca.reviewDomain.query.domain.entity;

import org.hibernate.annotations.Comment;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Table(name = "review")
public class QueryReview {

    @Id()
    @Column(name = "review_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNo;

    @Comment("리뷰 내용")
    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "country")
    private String country;

    @Column(name = "food_type")
    private String foodType;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @Column(name = "review_rate")
    private double reviewRate;

    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "food_no")
    private Integer foodNo;

    @Column(name = "review_keyword")
    private String reviewKeyword;

    @Column(name = "review_price")
    private int reviewPrice;

    @Column(name = "review_link")
    private String reviewLink;

    @Column(name = "like_cnt")
    private Integer likeCnt;

    public int getReviewNo() {
        return reviewNo;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public String getCountry() {
        return country;
    }

    public String getFoodType() {
        return foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public double getReviewRate() {
        return reviewRate;
    }

    public Integer getMemberNo() {
        return memberNo;
    }

    public Integer getFoodNo() {
        return foodNo;
    }

    public String getReviewKeyword() {
        return reviewKeyword;
    }

    public int getReviewPrice() {
        return reviewPrice;
    }

    public String getReviewLink() {
        return reviewLink;
    }

    public Integer getLikeCnt() {
        return likeCnt;
    }
}
