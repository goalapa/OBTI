package com.goalapa.cacamuca.foodDomain.query.application.controller;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodPicDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodEntity;
import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodPicRepository;
import com.goalapa.cacamuca.foodDomain.query.application.service.QueryFoodService;
import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.entity.Food;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.statDomain.query.application.dto.QueryStatDTO;
import com.goalapa.cacamuca.statDomain.query.domain.service.GetStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/*"})
@RequiredArgsConstructor
public class MainController {

    private final GetStatService getStatService;

    private final QueryFoodService queryFoodService;

    @GetMapping("/")
    public String main(@RequestParam(defaultValue = "한국") String country, Model model) {

        LocalDate today = LocalDate.now();

        List<QueryStatDTO> record =  getStatService.getStatTopTen(today, country);

        model.addAttribute("record", record);
        model.addAttribute("country", country);

        return "main";
    }

    @GetMapping("/country")
    public String showCountryFood(@PageableDefault Pageable pageable, @RequestParam String country, Model model) {

        Page<FoodEntity> countryFoods = queryFoodService.findFoodByCountry(pageable, country);
        List<FoodPicDTO> foodPics = queryFoodService.findAllFoodPic();

        model.addAttribute("countryFoods", countryFoods);
        model.addAttribute("foodPics", foodPics);
        model.addAttribute("country", country);

        return "mainCountry";
    }
}
