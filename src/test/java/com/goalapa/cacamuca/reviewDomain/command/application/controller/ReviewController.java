package com.goalapa.cacamuca.reviewDomain.command.application.controller;

import com.goalapa.cacamuca.reviewDomain.command.application.controller.Object.TestObjects;
import com.goalapa.cacamuca.reviewDomain.command.application.service.ReviewService;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.vo.ReviewWriter;
import com.goalapa.cacamuca.reviewDomain.command.domain.repository.ReviewRepository;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.domain.repository.ReviewMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
@SpringBootTest
public class ReviewController {
    private ReviewRepository reviewRepository;
    private ReviewMapper mapper;

    private static LocalDate date = LocalDate.now();
    private static Review review = TestObjects.createReview("존맛탱", "한국", "과자", "오레오", date, 5.0, 1, 1,
            "가성비", 3000, "dasdas.com", 10, 5);
    private static Review review2 = TestObjects.createReview("노맛", "한국", "과자", "오레오", date, 5.0, 1, 1,
            "가성비", 3000, "dasdas.com", 10, 5);

    @Autowired
    public ReviewController(ReviewRepository reviewRepository, ReviewMapper mapper) {
        this.reviewRepository = reviewRepository;
        this.mapper = mapper;
    }

    @DisplayName("저장 테스트")
    @Test
    void reviewSaveTest(){
        Assertions.assertDoesNotThrow(
                () -> reviewRepository.save(review)
        );
    }

    @DisplayName("찾기 테스트")
    @Test
    void findReviewTest(){
        int reviewNo = review.getReviewNo();

        Assertions.assertDoesNotThrow(
                () -> reviewRepository.findById(reviewNo)
        );
    }

    @DisplayName("목록 출력 테스트")
    @Test
    void findReviewAllTest(){
        reviewRepository.save(review);
        reviewRepository.save(review2);

//        List<QueryReviewDTO> reviews = mapper.findAllReviews(re);
//
//        Assertions.assertDoesNotThrow(
//                () -> reviewRepository.findById(reviewNo)
//        );

    }
}
