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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = {"/*/*", "/*"})
public class SelectReviewController {
    private final SelectReviewService selectReviewService;
    private static final Logger logger = LoggerFactory.getLogger(SelectReviewController.class);

    public SelectReviewController(SelectReviewService selectReviewService) {
        this.selectReviewService = selectReviewService;
    }


    @GetMapping("/selectReviews")
    public String selectReviews(Model model, @RequestParam String country){
        System.out.println("country = " + country);
        List<QueryReviewDTO> reviews = selectReviewService.findAllReviews();
        List<QueryReviewPicDTO> reviewPics = selectReviewService.findAllPictures();

        model.addAttribute("reviews", reviews);
        model.addAttribute("reviewPics", reviewPics);

        return "/review/selectReviews";
    }

    @GetMapping("/detail")
    public String selectReview(Model model, @RequestParam int no, @RequestParam(defaultValue = "1") int member){
        model.addAttribute("review", selectReviewService.findReviewByNo(no));
        model.addAttribute("reviewPic", selectReviewService.findReviewPicByNo(no));


        model.addAttribute("no", no);
        model.addAttribute("member", member);

        return "/review/reviewDetail";
    }

    @GetMapping("/search")
    public String searchReview(Model model, @RequestParam String search){
        model.addAttribute("searchResult", selectReviewService.searchReviews(search));

        return "review/search";
    }
}
