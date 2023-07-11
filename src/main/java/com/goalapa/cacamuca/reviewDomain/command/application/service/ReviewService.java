package com.goalapa.cacamuca.reviewDomain.command.application.service;

import com.goalapa.cacamuca.reviewDomain.command.application.dto.ReviewDTO;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Transactional
    public void saveReview(ReviewDTO reviewDTO) {
        LocalDate date = LocalDate.now();

        Review review = new Review(reviewDTO.getReviewContent(), reviewDTO.getCountry(), reviewDTO.getFoodType(), reviewDTO.getFoodName(), date, reviewDTO.getReviewRate(), reviewDTO.getMemberNo(), reviewDTO.getFoodNo()
                                    , reviewDTO.getReviewKeyword(), reviewDTO.getReviewPrice(), reviewDTO.getReviewLink());

        reviewRepository.save(review);
    }
}
