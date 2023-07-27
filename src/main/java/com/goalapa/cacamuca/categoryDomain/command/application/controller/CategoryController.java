package com.goalapa.cacamuca.categoryDomain.command.application.controller;


import com.goalapa.cacamuca.categoryDomain.command.application.dto.AddCategoryDTO;
import com.goalapa.cacamuca.categoryDomain.command.application.dto.UpdateCategoryDTO;
import com.goalapa.cacamuca.categoryDomain.command.application.service.AddCategoryService;
import com.goalapa.cacamuca.categoryDomain.command.application.service.UpdateCategoryService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller  //화면 리턴
@RequestMapping("/category")
public class CategoryController {


    private final AddCategoryService addCategoryService;
    private final UpdateCategoryService updateCategoryService;

    @Autowired
    public CategoryController(AddCategoryService addCategoryService, UpdateCategoryService updateCategoryService) {

        this.addCategoryService = addCategoryService;
        this.updateCategoryService = updateCategoryService;
    }

    //카테고리 추가 기능 구현
    @GetMapping("/add")
    public String categoryAdd() {

        return "/category/add";
    }

    @PostMapping("/add")
    public String addCategory(@ModelAttribute AddCategoryDTO addCategoryDTO) {

        System.out.println("addCategoryDTO = " + addCategoryDTO);

        //add카테고리서비스에 보내기
        addCategoryService.addCategory(addCategoryDTO);


        return "add-result";

//        return "redirect:/category/add-result";
    }

    //카테고리 수정 기능 구현
    @GetMapping("/update")
    public String checkCategory() {
        return "/category/update";
    }

    @PostMapping("/update")
    public String UpdateCheckCategory(@ModelAttribute UpdateCategoryDTO updateCategoryDTO) {

        System.out.println("updateCategoryDTO = " + updateCategoryDTO);

        updateCategoryService.checkUpdate(updateCategoryDTO);


        return "/category/update-result";
    }

}
