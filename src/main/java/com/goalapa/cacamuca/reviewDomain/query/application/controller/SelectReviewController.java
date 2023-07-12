package com.goalapa.cacamuca.reviewDomain.query.application.controller;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.service.SelectReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/*")
public class SelectReviewController {
    private final SelectReviewService selectReviewService;

    public SelectReviewController(SelectReviewService selectReviewService) {
        this.selectReviewService = selectReviewService;
    }


    @GetMapping("/selectReviews")
    public String selectReviews(Model model){
//        List<QueryReviewPicDTO> reviewPictures = selectReviewService.getPictures();
//
//        model.addAttribute("reviewPictures", reviewPictures);

        List<QueryReviewDTO> reviews = selectReviewService.findAllReviews();
        System.out.println("reviews = " + reviews);

//        model.addAttribute("reviews", reviews);


        return "selectReviews";
    }
}
