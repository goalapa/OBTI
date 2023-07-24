package com.goalapa.cacamuca.reviewDomain.command.application.controller;

import com.goalapa.cacamuca.memberDomain.command.application.dto.CustomUser;
import com.goalapa.cacamuca.reviewDomain.command.application.dto.ReviewDTO;
import com.goalapa.cacamuca.reviewDomain.command.application.service.ReviewService;
import com.goalapa.cacamuca.reviewDomain.query.application.controller.SelectReviewController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.exceptions.TemplateInputException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/review/*")
public class ReviewController {
    private final ReviewService reviewService;
    private static final Logger logger = LoggerFactory.getLogger(SelectReviewController.class);

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/review")
    public String reviewPage(){
        return "review";
    }

    @PostMapping("/review")
    public String writeReview(@RequestParam List<MultipartFile> reviewPicUrl, @ModelAttribute ReviewDTO reviewDTO,
                              @AuthenticationPrincipal CustomUser user, HttpServletRequest request){
        int loginMemberNo = user.getMemberNo();

        reviewService.saveReview(reviewDTO, reviewPicUrl,loginMemberNo);

        return "redirect:/review/selectReviews";
    }

    @PostMapping("/reviewDetail")
    @ResponseBody
    public Map<String, Object> CountHeart(@RequestBody HashMap<String, Object> parameter,
                                          @AuthenticationPrincipal CustomUser user){
            String no = (String) parameter.get("no");
            Integer reviewNo =  Integer.parseInt(no);
            Integer memberNo = Integer.parseInt((String) parameter.get("member"));

            int loginMemberNo = user.getMemberNo();

            reviewService.countHeart(reviewNo, loginMemberNo);

            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("no", Integer.valueOf(reviewNo).toString());
            responseMap.put("member", memberNo);
            return responseMap;
    }

    @PostMapping("/report")
    public void countReport(@RequestBody HashMap<String, Object> param,
                            @AuthenticationPrincipal CustomUser user){
        int reportReason = Integer.parseInt((String) param.get("reportReason"));
        int memberNo = Integer.parseInt((String) param.get("member"));
        int reviewNo = Integer.parseInt((String) param.get("no"));
        int loginMemberNo = user.getMemberNo();

        System.out.println("신고 이유는 = " + reportReason);
        System.out.println("작성자의 번호는 = " + memberNo);
        System.out.println("리뷰의 번호는 = " + reviewNo);
        System.out.println("로그인 유저의 번호는 = " + loginMemberNo);

        boolean reportResult = reviewService.countReport(reportReason, reviewNo, memberNo, loginMemberNo);
        System.out.println("신고 결과는 = " + reportResult);
    }
}
