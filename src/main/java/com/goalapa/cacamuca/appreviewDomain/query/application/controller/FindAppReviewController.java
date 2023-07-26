package com.goalapa.cacamuca.appreviewDomain.query.application.controller;

import com.goalapa.cacamuca.appreviewDomain.command.domain.aggregate.entity.AppReview;
import com.goalapa.cacamuca.appreviewDomain.query.application.service.FindAppReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FindAppReviewController {

    private final FindAppReviewService findAppReviewService;

    public FindAppReviewController(FindAppReviewService findAppReviewService) {
        this.findAppReviewService = findAppReviewService;
    }

    @GetMapping("/admin-page/app-review")
    public String adminAppReviewPage(Model model, @PageableDefault Pageable pageable) {
        Page<AppReview> appReview = findAppReviewService.findAllAppReview(pageable);
        Float reviewAvg = findAppReviewService.findAvgAppReviewRate();

        model.addAttribute("appReview", appReview);
        model.addAttribute("reviewAvg", reviewAvg);

        return "adminAppRev";
    }
}
