package com.goalapa.cacamuca.categoryDomain.query.application.controller;

import com.goalapa.cacamuca.categoryDomain.query.application.service.QueryCategoryServiceImpl;
import com.goalapa.cacamuca.categoryDomain.query.domain.aggregate.dto.CategoryListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("category-list")
@RequiredArgsConstructor
public class QueryCategoryController {

    private final QueryCategoryServiceImpl queryCategoryServiceImpl;


    @GetMapping("/category-list")
    public ModelAndView findCategoryPage(ModelAndView mv, @PageableDefault(sort = "category_no") Pageable pageable) {

        Page<CategoryListDTO> categories = queryCategoryServiceImpl.findQueryCategoryList(pageable);

        mv.addObject("categories", categories);
        mv.setViewName("category-list");

        return mv;
    }
}
