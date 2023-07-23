package com.goalapa.cacamuca.foodDomain.command.application.controller;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodFromRequest;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodPicFromRequest;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FoodController {

    private final SaveFoodFromRequest saveFoodFromRequest;
    private final SaveFoodPicFromRequest saveFoodPicFromRequest;

    public FoodController(SaveFoodFromRequest saveFoodFromRequest, SaveFoodPicFromRequest saveFoodPicFromRequest) {
        this.saveFoodFromRequest = saveFoodFromRequest;
        this.saveFoodPicFromRequest = saveFoodPicFromRequest;
    }

    @PostMapping( "/request-list/view/save-request")
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
}
