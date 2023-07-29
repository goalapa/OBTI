package com.goalapa.cacamuca.reviewDomain.command.application.controller.Object;

import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.ReviewPic;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.vo.ReviewWriter;

import java.time.LocalDate;

public class TestObjects {

    public static Review createReview(String reviewContent, String country, String foodType, String foodName, LocalDate date, double reviewRate, int memberNo, Integer foodNo,
                                      String reviewKeyword, int reviewPrice, String reviewLink, Integer reportCnt, Integer likeCnt){
        Review review = new Review();
        ReviewWriter writer = new ReviewWriter();

        review.setReportCnt(reportCnt);
        review.setLikeCnt(likeCnt);
        review.setReviewContent(reviewContent);
        review.setReviewDate(date);
        review.setReviewLink(reviewLink);
        review.setReviewKeyword(reviewKeyword);
        review.setReviewPrice(reviewPrice);
        review.setCountry(country);
        review.setFoodType(foodType);
        review.setFoodName(foodName);
        review.setReviewRate(reviewRate);
        review.setFoodNo(foodNo);
        writer.setReviewWriterMemberId(memberNo);

        return review;
    }

    public static ReviewPic createReviewPic(Review review){
        ReviewPic reviewPic = new ReviewPic();
        reviewPic.setReviewNo(review);

        return reviewPic;
    }
}
