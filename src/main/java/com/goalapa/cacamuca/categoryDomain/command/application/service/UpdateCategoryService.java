package com.goalapa.cacamuca.categoryDomain.command.application.service;

import com.goalapa.cacamuca.categoryDomain.command.application.dto.UpdateCategoryDTO;
import com.goalapa.cacamuca.categoryDomain.command.domain.aggregate.entity.CategoryEntity;
import com.goalapa.cacamuca.categoryDomain.command.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void checkUpdate(UpdateCategoryDTO updateCategoryDTO) {

        CategoryEntity category = categoryRepository.findCategoryEntityByCountryAndFoodType(updateCategoryDTO.getCountry(), updateCategoryDTO.getFoodType());
        //카테고리 엔티티를 가져옴
        System.out.println("category = " + category);


        category.setCountry(updateCategoryDTO.getReplaceCountry());
        category.setFoodType(updateCategoryDTO.getReplaceFoodType());

        categoryRepository.save(category);


    }

}
