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

        category.setCountry(updateCategoryDTO.getReplaceCountry());
        category.setFoodType(updateCategoryDTO.getReplaceFoodType());

        categoryRepository.save(category);
    }

}
