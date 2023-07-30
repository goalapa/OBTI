package com.goalapa.cacamuca.foodDomain.command.application.controller;

import com.goalapa.cacamuca.categoryDomain.command.application.dto.AddCategoryDTO;
import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.application.service.FoodRegistService;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodFromRequest;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodPicFromRequest;
import com.goalapa.cacamuca.requestDomain.command.application.service.DeleteRequestImpl;
import com.goalapa.cacamuca.requestDomain.command.application.service.DeleteRequestPicImpl;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FoodController {

    private final SaveFoodFromRequest saveFoodFromRequest;
    private final SaveFoodPicFromRequest saveFoodPicFromRequest;
    private final FoodRegistService foodRegistService;

    private final DeleteRequestImpl deleteRequestImpl;
    private final DeleteRequestPicImpl deleteRequestPicImpl;

    public FoodController(SaveFoodFromRequest saveFoodFromRequest, SaveFoodPicFromRequest saveFoodPicFromRequest, FoodRegistService foodRegistService, DeleteRequestImpl deleteRequestImpl, DeleteRequestPicImpl deleteRequestPicImpl) {
        this.saveFoodFromRequest = saveFoodFromRequest;
        this.saveFoodPicFromRequest = saveFoodPicFromRequest;
        this.foodRegistService = foodRegistService;
        this.deleteRequestImpl = deleteRequestImpl;
        this.deleteRequestPicImpl = deleteRequestPicImpl;
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

        deleteRequestImpl.deleteRequest(findRequestDTO.getRequestNo());
        deleteRequestPicImpl.deleteRequestPic(findRequestDTO.getRequestNo());

        return "redirect:/request-list";
    }

    //식품 등록
    @GetMapping("/food/food-regist")
    public String foodRegist() {
        return "food/food-regist";
    }

    @PostMapping("/food/food-regist")
    public String registFood(@RequestParam MultipartFile registPic, @ModelAttribute FoodDTO foodDTO) throws IOException, IOException {


        foodRegistService.saveFood(foodDTO, registPic);


        return "redirect:/food/food-list";
    }


    //식품 삭제
    @GetMapping("/food/delete/{foodNo}")
    public String deleteFood(@PathVariable("foodNo") Integer foodNo) {

        foodRegistService.deleteFood(foodNo);
        foodRegistService.deleteFoodPic(foodNo);

        return "redirect:/food/food-list";
    }
}
