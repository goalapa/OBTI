package com.goalapa.cacamuca.reviewDomain.query.application.controller;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.service.SelectReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class SelectReviewController {
    private final SelectReviewService selectReviewService;

    public SelectReviewController(SelectReviewService selectReviewService) {
        this.selectReviewService = selectReviewService;
    }

    @GetMapping("/selectReview")
    public String selectReviews(Model model){

        QueryReviewDTO queryReviewDTO = selectReviewService.getReviews();

        return "selectReviews";
    }
}
