package com.goalapa.cacamuca.categoryDomain.command.application.service;


import com.goalapa.cacamuca.categoryDomain.command.application.dto.AddCategoryDTO;
import com.goalapa.cacamuca.categoryDomain.command.domain.aggregate.entity.CategoryEntity;
import com.goalapa.cacamuca.categoryDomain.command.domain.repository.CategoryRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(AddCategoryDTO categoryDTO) {

        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setSubCategoryName(categoryDTO.getSubCategoryName());

        categoryRepository.save(category);
    }

}
