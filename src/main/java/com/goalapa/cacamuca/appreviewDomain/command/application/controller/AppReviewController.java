package com.goalapa.cacamuca.appreviewDomain.command.application.controller;


import com.goalapa.cacamuca.appreviewDomain.command.domain.service.SaveAppReviewImpl;
import com.goalapa.cacamuca.memberDomain.command.application.dto.CustomUser;
import com.goalapa.cacamuca.appreviewDomain.command.application.dto.AppReviewDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppReviewController {

    private final SaveAppReviewImpl saveAppReviewImpl;

    public AppReviewController(SaveAppReviewImpl saveAppReviewImpl) {
        this.saveAppReviewImpl = saveAppReviewImpl;
    }

    @GetMapping("/app-review")
    public String requestPage() {
        return "app-review";
    }

    @PostMapping("/app-review")
    public String saveRequest(@AuthenticationPrincipal CustomUser customUser, @ModelAttribute AppReviewDTO appReviewDTO) {

        saveAppReviewImpl.saveAppReview(appReviewDTO, customUser.getMemberNo(), customUser.getMemberNickname());
        return "redirect:/";

    }

}
