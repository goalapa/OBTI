package com.goalapa.cacamuca.foodDomain.command.application.controller;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.application.service.FoodRegistService;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodFromRequest;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodPicFromRequest;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
//@RequestMapping("/food-regist")
public class FoodController {

    private final SaveFoodFromRequest saveFoodFromRequest;
    private final SaveFoodPicFromRequest saveFoodPicFromRequest;
    private final FoodRegistService foodRegistService;

    public FoodController(SaveFoodFromRequest saveFoodFromRequest, SaveFoodPicFromRequest saveFoodPicFromRequest, FoodRegistService foodRegistService) {
        this.saveFoodFromRequest = saveFoodFromRequest;
        this.saveFoodPicFromRequest = saveFoodPicFromRequest;
        this.foodRegistService = foodRegistService;
    }

    @PostMapping("/request-list/view/save-request")
    public String saveRequest(@ModelAttribute FindRequestDTO findRequestDTO, @RequestParam("imageUrl") String url) {

        FoodDTO food = new FoodDTO();
        food.setFoodName(findRequestDTO.getRequestFood());
        food.setFoodPrice(findRequestDTO.getRequestPrice());
        food.setFoodType(findRequestDTO.getRequestFoodType());
        food.setCountry(findRequestDTO.getRequestCountry());

        saveFoodFromRequest.saveFoodFromRequest(food);
        saveFoodPicFromRequest.saveFoodPicFromRequest(url);

        return "redirect:/request-list";
    }

    //식품 등록
//    @GetMapping("")
//    public String foodRegist() {
//        return "food-regist";
//    }
//
//    @PostMapping("")
//    public String registFood(@RequestParam MultipartFile registPic, @ModelAttribute FoodDTO foodDTO) throws IOException {
//
//
//        foodRegistService.saveFood(foodDTO, registPic);
//
//
//        return "food-regist";
//    }
//
//
//    //식품 삭제
//    @GetMapping("/test")
//    public void deleteFood(@PathVariable int foodNo) {
//
//        foodRegistService.deleteFood(foodNo);
//        foodRegistService.deleteFoodPic(foodNo);
//    }
}
