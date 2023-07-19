package com.goalapa.cacamuca.reviewDomain.command.application.dto;

import javax.persistence.Column;

public class ReviewLikeDTO {
    private int memberNo;
    private int reviewNo;

    public ReviewLikeDTO() {
    }

    public ReviewLikeDTO(int memberNo, int reviewNo) {
        this.memberNo = memberNo;
        this.reviewNo = reviewNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    @Override
    public String toString() {
        return "ReviewLikeDTO{" +
                "memberNo=" + memberNo +
                ", reviewNo=" + reviewNo +
                '}';
    }
}
