package com.goalapa.cacamuca.reviewDomain.query.application.controller;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewFoodDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewWriterDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.service.SelectReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/*/*", "/*"})
public class SelectReviewController {
    private final SelectReviewService selectReviewService;
    private static final Logger logger = LoggerFactory.getLogger(SelectReviewController.class);

    public SelectReviewController(SelectReviewService selectReviewService) {
        this.selectReviewService = selectReviewService;
    }

    @GetMapping("/selectReviews")
    public String selectReviews(Model model, @RequestParam String foodName, @RequestParam String country,
                                @PageableDefault(size = 10, sort = "review_no", direction = Sort.Direction.DESC) Pageable pageable
    ){
//        List<QueryReviewDTO> reviews = selectReviewService.findAllReviews(foodName, country);
        Page<QueryReviewDTO> reviewPages = selectReviewService.findAllReviews(foodName, country, pageable);
        List<QueryReviewPicDTO> reviewPics = selectReviewService.findAllPictures(foodName, country);
        List<QueryReviewWriterDTO> reviewWriters = selectReviewService.findReviewWriter(foodName, country);

        System.out.println("reviewWriters = " + reviewWriters);
        System.out.println("reviewPics = " + reviewPics);

        model.addAttribute("foodName", foodName);
        model.addAttribute("country",country);
        model.addAttribute("reviewPages", reviewPages);
        model.addAttribute("reviewPics", reviewPics);
        model.addAttribute("reviewWriters", reviewWriters);
        

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
    public String searchReview(Model model, @RequestParam String search
            , @PageableDefault(size = 10, sort = "review_no", direction = Sort.Direction.DESC) Pageable pageable
    ){
        Page<QueryReviewDTO> searchReviews = selectReviewService.searchReviews(search, pageable);
        List<QueryReviewPicDTO> searchPics = selectReviewService.findAllPictures(search);
        List<QueryReviewWriterDTO> reviewWriters = selectReviewService.findReviewWriter(search);
        System.out.println("작성자 리스트 = " + reviewWriters);

        model.addAttribute("searchReviews",searchReviews);
        model.addAttribute("search", search);
        model.addAttribute("searchPics", searchPics);
        model.addAttribute("reviewWriters", reviewWriters);

        return "review/search";
    }

    @PostMapping("/checkValue")
    @ResponseBody
    public List<String> checkValue(@RequestBody HashMap<String, Object> param){
        String country = (String) param.get("country");
        String foodType = (String) param.get("foodType");

        List<QueryReviewFoodDTO> foods = selectReviewService.checkValue(country, foodType);
        List<String> food = new ArrayList<>();
        for(int i=0; i<foods.size(); i++) {
            food.add(foods.get(i).getFoodName());
        }
        System.out.println("food = " + food);
        return food;
    }

}
