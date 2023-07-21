package com.goalapa.cacamuca.reviewDomain.query.application.dto;

public class QueryReviewPicDTO {
    private Integer reviewPicNo;
    private Integer reviewNo;
    private String reviewPicUrl;

    public QueryReviewPicDTO() {
    }

    public Integer getReviewPicNo() {
        return reviewPicNo;
    }

    public Integer getReviewNo() {
        return reviewNo;
    }

    public String getReviewPicUrl() {
        return reviewPicUrl;
    }

    @Override
    public String toString() {
        return "QueryReviewPicDTO{" +
                "reviewPicNo=" + reviewPicNo +
                ", reviewNo=" + reviewNo +
                ", reviewPicUrl='" + reviewPicUrl + '\'' +
                '}';
    }
}
