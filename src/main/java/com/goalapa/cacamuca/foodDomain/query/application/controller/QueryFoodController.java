package com.goalapa.cacamuca.foodDomain.query.application.controller;



import com.goalapa.cacamuca.foodDomain.query.application.dto.QueryFoodDTO;
import com.goalapa.cacamuca.foodDomain.query.application.service.QueryFoodService;
import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/food/*")
public class QueryFoodController {

    private final QueryFoodService queryFoodService;

    @Autowired
    public QueryFoodController(QueryFoodService queryFoodService) {
        this.queryFoodService = queryFoodService;
    }

    @GetMapping("food-list")
    public String getFoodList(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int pageSize,
                              @RequestParam(defaultValue = "foodNo") String sortBy, Model model) {

        Page<QueryFoodDTO> foodListPage = queryFoodService.getFoodList(page, pageSize, sortBy);
        model.addAttribute("foods", foodListPage.getContent());
        model.addAttribute("currentPage", foodListPage.getNumber() + 1);
        model.addAttribute("totalPages", foodListPage.getTotalPages());

        return "food/food-list";
    }

    @GetMapping("detail/{foodNo}")
    public String foodListDetail(@PathVariable Integer foodNo, Model model) {

        Food food = queryFoodService.findById(foodNo);
        model.addAttribute("food", food);
        return "food/detail";
    }
}
