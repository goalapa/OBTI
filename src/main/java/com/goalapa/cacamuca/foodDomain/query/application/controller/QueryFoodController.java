package com.goalapa.cacamuca.foodDomain.query.application.controller;



import com.goalapa.cacamuca.foodDomain.query.application.service.QueryFoodServiceImpl;
import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.dto.CheckFoodDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
public class QueryFoodController {

    private final QueryFoodServiceImpl queryFoodServiceImpl;


    @GetMapping("/food-list")
    public ModelAndView findFoodRegistPage(ModelAndView mv, @PageableDefault(sort="food_name") Pageable pageable) {

        Page<CheckFoodDTO> foodRegistPage = queryFoodServiceImpl.findFoodRegistList(pageable);

        mv.addObject("foodRegistPage", foodRegistPage);
        mv.setViewName("food-list");

        return mv;
    }

}
