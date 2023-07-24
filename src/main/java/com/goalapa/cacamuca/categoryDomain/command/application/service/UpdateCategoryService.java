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

        System.out.println("updateCategoryDTO = " + updateCategoryDTO);

        CategoryEntity category = categoryRepository.findByCountryAndFoodType(updateCategoryDTO.getCountry(), updateCategoryDTO.getFoodType());
        //카테고리 엔티티를 가져옴

        if(category != null) {
            category.setCountry(updateCategoryDTO.getReplaceCountry());
            category.setFoodType(updateCategoryDTO.getReplaceFoodType());

            categoryRepository.save(category);
        }

    }
//
//    @Transactional
//    public void UpdateCheckCategory(UpdateCategoryDTO updateCategoryDTO) {
//
//        CategoryEntity category = new CategoryEntity();
//        category.setReplaceCountry(updateCategoryDTO.getCountry());
//        category.setReplaceFoodType(updateCategoryDTO.getFoodType());
//
//        categoryRepository.save(category);
//    }





}
