package com.goalapa.cacamuca.categoryDomain.query.application.service;

import com.goalapa.cacamuca.categoryDomain.query.domain.aggregate.dto.CategoryListDTO;
import com.goalapa.cacamuca.categoryDomain.query.domain.aggregate.entity.Category;
import com.goalapa.cacamuca.categoryDomain.query.domain.repository.CategoryListMapper;
import com.goalapa.cacamuca.categoryDomain.query.domain.service.QueryCategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryCategoryServiceImpl implements QueryCategoryService {

    private final CategoryListMapper categoryListMapper;
    private final ModelMapper modelMapper;



    public Page<CategoryListDTO> findQueryCategoryList(Pageable pageable) {

        List<Category> categoryList = categoryListMapper.findCategories(pageable);

        Integer count = categoryListMapper.countCategories();

        List<CategoryListDTO> categories = categoryList.stream().map(category -> modelMapper.map(category, CategoryListDTO.class)).collect(Collectors.toList());

        Page<CategoryListDTO> page = new PageImpl<>(categories, pageable, count);

        return page;
    }
}
