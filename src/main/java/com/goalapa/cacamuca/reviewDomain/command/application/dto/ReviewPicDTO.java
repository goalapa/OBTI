package com.goalapa.cacamuca.reviewDomain.command.application.dto;

import javax.persistence.Column;

public class ReviewPicDTO {
    private Integer reviewPicNo;
    private Integer reviewNo;
    private String reviewPicUrl;

    public ReviewPicDTO() {
    }

    public ReviewPicDTO(Integer reviewPicNo, Integer reviewNo, String reviewPicUrl) {
        this.reviewPicNo = reviewPicNo;
        this.reviewNo = reviewNo;
        this.reviewPicUrl = reviewPicUrl;
    }

    public Integer getReviewPicNo() {
        return reviewPicNo;
    }

    public void setReviewPicNo(Integer reviewPicNo) {
        this.reviewPicNo = reviewPicNo;
    }

    public Integer getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(Integer reviewNo) {
        this.reviewNo = reviewNo;
    }

    public String getReviewPicUrl() {
        return reviewPicUrl;
    }

    public void setReviewPicUrl(String reviewPicUrl) {
        this.reviewPicUrl = reviewPicUrl;
    }

    @Override
    public String toString() {
        return "ReviewPicDTO{" +
                "reviewPicNo=" + reviewPicNo +
                ", reviewNo=" + reviewNo +
                ", reviewPicUrl='" + reviewPicUrl + '\'' +
                '}';
    }
}
