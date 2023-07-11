package com.goalapa.cacamuca.reviewDomain.command.application.controller;

import com.goalapa.cacamuca.reviewDomain.command.application.dto.ReviewDTO;
import com.goalapa.cacamuca.reviewDomain.command.infrastructure.service.ReviewServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/*")
public class ReviewController {
    private final ReviewServiceImpl reviewServiceImpl;

    public ReviewController(ReviewServiceImpl reviewServiceImpl) {
        this.reviewServiceImpl = reviewServiceImpl;
    }


    @GetMapping("/review")
    public String reviewPage(){
        return "review";
    }

    @PostMapping("/review")
    public void writeReview(HttpServletRequest request){
        ReviewDTO reviewDTO = new ReviewDTO();

        reviewDTO.setCountry(request.getParameter("country"));
        reviewDTO.setFoodType(request.getParameter("food_type"));
        reviewDTO.setReviewKeyword(request.getParameter("reviewKeyword"));
        reviewDTO.setFoodName(request.getParameter("food_name"));
        reviewDTO.setReviewPrice(Integer.parseInt(request.getParameter("review_price")));
        reviewDTO.setReviewRate(Integer.parseInt(request.getParameter("reviewRate")));
        reviewDTO.setReviewLink(request.getParameter("review_link"));

        reviewServiceImpl.saveReview(reviewDTO);

    }
}
