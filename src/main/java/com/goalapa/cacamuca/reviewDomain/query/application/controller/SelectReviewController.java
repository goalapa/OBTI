package com.goalapa.cacamuca.reviewDomain.query.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class SelectReviewController {
    @GetMapping("/selectReview")
    public String selectReview(){
        

        return "selectReview";
    }
}
