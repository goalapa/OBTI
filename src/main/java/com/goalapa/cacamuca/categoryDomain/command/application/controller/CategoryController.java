package com.goalapa.cacamuca.categoryDomain.command.application.controller;


import com.goalapa.cacamuca.categoryDomain.command.application.dto.AddCategoryDTO;
import com.goalapa.cacamuca.categoryDomain.command.application.dto.UpdateCategoryDTO;
import com.goalapa.cacamuca.categoryDomain.command.application.service.AddCategoryService;
import com.goalapa.cacamuca.categoryDomain.command.application.service.UpdateCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller  //화면 리턴
@RequestMapping("/") //URL로 요청을 보내면 컨트롤러에서 어떤 방식으로 처리할지 정의(들어온 요청을 특정 메소드와 매핑하기 위해 사용하는 어노테이션)
public class CategoryController {

    //식별자 생성
    private final AddCategoryService addCategoryService;
    private final UpdateCategoryService updateCategoryService;

    @Autowired
    public CategoryController(AddCategoryService addCategoryService, UpdateCategoryService updateCategoryService) {

        this.addCategoryService = addCategoryService;
        this.updateCategoryService = updateCategoryService;
    }

    //카테고리 추가 기능 구현
    @GetMapping("category/add")
    public String categoryAdd() {

        return "category/add";
    }

    @PostMapping("category/add")
    public String addCategory(@ModelAttribute AddCategoryDTO addCategoryDTO) {


        System.out.println("컨트롤러에서 넘기는 addCategoryDTO = " + addCategoryDTO);
        //add카테고리서비스에 보내기
        addCategoryService.addCategory(addCategoryDTO);


        return "category/category-result";
    }

    //카테고리 수정 기능 구현
    @GetMapping("update-category")
    public String checkCategory(Model model, @ModelAttribute("category") UpdateCategoryDTO updateCategoryDTO) {

        updateCategoryService.checkUpdate(updateCategoryDTO);

        return "category/update-category";
    }

    @PostMapping("update-category")
    public String UpdateCheckCategory(Model model, @ModelAttribute("category") UpdateCategoryDTO updateCategoryDTO) {

        updateCategoryService.checkUpdate(updateCategoryDTO);

        return "category/category-update-result";
    }

}



