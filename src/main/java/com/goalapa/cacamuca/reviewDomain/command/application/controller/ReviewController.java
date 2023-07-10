package com.goalapa.cacamuca.reviewDomain.command.application.controller;

import com.goalapa.cacamuca.reviewDomain.command.application.dto.ReviewDTO;
import com.goalapa.cacamuca.reviewDomain.command.application.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void writeReview(HttpServletRequest request){
        String country = request.getParameter("country");
        String foodType = request.getParameter("food_type");
        String reviewKeyword = request.getParameter("reviewKeyword");
        String foodName = request.getParameter("food_name");
        int foodPrice = Integer.parseInt(request.getParameter("review_price"));
        int reviewRate = Integer.parseInt(request.getParameter("reviewRate"));
        String reviewLink = request.getParameter("review_link");

        ReviewDTO reviewDTO = new ReviewDTO();


//        System.out.println("나라 = " + country);
//        System.out.println("식품종류 = " + foodType);
//        System.out.println("키워드 = " + reviewKeyword);
//        System.out.println("식품이름 = " + foodName);
//        System.out.println("가격 = " + foodPrice);
//        System.out.println("링크 = " + reviewLink);
//        System.out.println("별점 = " + reviewRate);


    }
}
