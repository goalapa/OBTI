package com.goalapa.cacamuca.foodDomain.query.application.controller;

import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodPicRepository;
import com.goalapa.cacamuca.statDomain.query.application.dto.QueryStatDTO;
import com.goalapa.cacamuca.statDomain.query.domain.service.GetStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/*"})
@RequiredArgsConstructor
public class MainController {

    private final GetStatService getStatService;

    @GetMapping("/")
    public String main(@RequestParam(defaultValue = "한국") String country, Model model) {

        LocalDate today = LocalDate.now();

        List<QueryStatDTO> record =  getStatService.getStatTopTen(today, country);

        model.addAttribute("record", record);
        model.addAttribute("country", country);

        return "main";
    }
}
