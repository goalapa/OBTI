package com.goalapa.cacamuca.reviewDomain.query.application.controller;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.service.SelectReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Controller
@RequestMapping("/*")
public class SelectReviewController {
    private final SelectReviewService selectReviewService;
    private static final Logger logger = LoggerFactory.getLogger(SelectReviewController.class);

    public SelectReviewController(SelectReviewService selectReviewService) {
        this.selectReviewService = selectReviewService;
    }


    @GetMapping("/selectReviews")
    public String selectReviews(Model model){
//        List<QueryReviewPicDTO> reviewPictures = selectReviewService.getPictures();
//        model.addAttribute("reviewPictures", reviewPictures);

        List<QueryReviewDTO> reviews = selectReviewService.findAllReviews();

        model.addAttribute("reviews", reviews);

        return "selectReviews";
    }

    @GetMapping("/detail")
    public String selectReview(Model model, @RequestParam int no){
        model.addAttribute("review", selectReviewService.findReviewByNo(no));

        QueryReviewDTO review = selectReviewService.findReviewByNo(no);
//        logger.info(String.valueOf(review.getReviewRate()));

        return "reviewDetail";
    }
}
