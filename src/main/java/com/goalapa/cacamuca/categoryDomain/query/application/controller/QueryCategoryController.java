package com.goalapa.cacamuca.categoryDomain.query.application.controller;

import com.goalapa.cacamuca.categoryDomain.query.application.dto.QueryCategoryDTO;
import com.goalapa.cacamuca.categoryDomain.query.application.service.QueryCategoryService;
import com.goalapa.cacamuca.categoryDomain.query.domain.aggregate.entity.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/category/*")
public class QueryCategoryController {

    private final QueryCategoryService queryCategoryService;

    @Autowired
    public QueryCategoryController(QueryCategoryService queryCategoryService) {
        this.queryCategoryService = queryCategoryService;
    }


    @GetMapping("/category-list")
    public String getCategoryList(@RequestParam(defaultValue = "1") int page,
                                  @RequestParam(defaultValue = "10") int pageSize,
                                  @RequestParam(defaultValue = "categoryNo") String sortBy, Model model) {

        Page<QueryCategoryDTO> categoryListPage = queryCategoryService.getCategoryList(page, pageSize, sortBy);
        model.addAttribute("categories", categoryListPage.getContent());
        model.addAttribute("currentPage", categoryListPage.getNumber() + 1);
        model.addAttribute("totalPages", categoryListPage.getTotalPages());

        return "category/category-list";
    }

    @GetMapping("detail/{categoryNo}")
    public String categoryListDetail(@PathVariable Integer categoryNo, Model model) {

        Category category = queryCategoryService.findById(categoryNo);
        model.addAttribute("category", category);
        return "category/cateogry-list";
    }
}
