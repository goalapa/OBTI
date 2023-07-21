package com.goalapa.cacamuca.foodDomain.command.application.controller;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.Food;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.Country;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.FoodType;
import com.goalapa.cacamuca.foodDomain.command.domain.service.SaveFoodFromRequest;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodController {

    private final SaveFoodFromRequest saveFoodFromRequest;

    public FoodController(SaveFoodFromRequest saveFoodFromRequest) {
        this.saveFoodFromRequest = saveFoodFromRequest;
    }

    @PostMapping( "/request-list/view/save-request")
    public String saveRequest(@ModelAttribute FindRequestDTO findRequestDTO) {

        FoodDTO food = new FoodDTO();
        food.setFoodName(findRequestDTO.getRequestFood());
        food.setFoodPrice(findRequestDTO.getRequestPrice());
        food.setFoodType(findRequestDTO.getRequestFoodType());
        food.setCountry(findRequestDTO.getRequestCountry());

        saveFoodFromRequest.saveFoodFromRequest(food);

        return "redirect:/request-list";
    }
}
