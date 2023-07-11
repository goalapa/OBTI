package com.goalapa.cacamuca.reviewDomain.command.application.controller;

import com.goalapa.cacamuca.reviewDomain.command.application.dto.ReviewDTO;
import com.goalapa.cacamuca.reviewDomain.command.application.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/*")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    @GetMapping("/review")
    public String reviewPage(){
        return "review";
    }

    @PostMapping("/review")
    public String writeReview(HttpServletRequest request){
        ReviewDTO reviewDTO = new ReviewDTO();

        reviewDTO.setReviewContent(request.getParameter("reviewContent"));
        reviewDTO.setCountry(request.getParameter("country"));
        reviewDTO.setFoodType(request.getParameter("food_type"));
        reviewDTO.setReviewKeyword(request.getParameter("reviewKeyword"));
        reviewDTO.setFoodName(request.getParameter("food_name"));
        reviewDTO.setReviewPrice(Integer.parseInt(request.getParameter("review_price")));
        reviewDTO.setReviewRate(Integer.parseInt(request.getParameter("reviewRate")));
        reviewDTO.setReviewLink(request.getParameter("review_link"));

        reviewService.saveReview(reviewDTO);

        return "redirect:/";
    }
}
