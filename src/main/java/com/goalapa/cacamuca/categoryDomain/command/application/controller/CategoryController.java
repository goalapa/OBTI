package com.goalapa.cacamuca.categoryDomain.command.application.controller;


import com.goalapa.cacamuca.categoryDomain.command.application.dto.AddCategoryDTO;
import com.goalapa.cacamuca.categoryDomain.command.application.service.AddCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/category/*")
public class CategoryController {

    //식별자 생성
    private final AddCategoryService addCategoryService;
    @Autowired
    public CategoryController(AddCategoryService addCategoryService) {

        this.addCategoryService = addCategoryService;
    }

    @GetMapping("/addCategory")
    public String add() {

        return "contents/addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategory(@ModelAttribute("category") AddCategoryDTO addCategoryDTO) {


        addCategoryService.addCategory(addCategoryDTO);


        return "contents/categoryResult";
    }
}



