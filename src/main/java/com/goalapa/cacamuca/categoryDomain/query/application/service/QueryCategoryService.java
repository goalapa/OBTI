package com.goalapa.cacamuca.categoryDomain.query.application.service;

import com.goalapa.cacamuca.categoryDomain.query.application.dto.QueryCategoryDTO;
import com.goalapa.cacamuca.categoryDomain.query.domain.aggregate.entity.Category;
import com.goalapa.cacamuca.categoryDomain.query.infrastructure.repository.CategoryMapper;
import com.goalapa.cacamuca.categoryDomain.query.infrastructure.repository.QueryCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service(value = "QueryApplicationCategoryService")

public class QueryCategoryService {

    private final QueryCategoryRepository queryCategoryRepository;
    private final CategoryMapper categoryMapper;

    public List<QueryCategoryDTO> findAllCategory() {
        return categoryMapper.findAllCategory();
    }

    public Page<QueryCategoryDTO> getCategoryList(int pageNo, int pageSize, String sortBy) {

        int pageNumber = pageNo -1;
        Sort sort = Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Category> categoryListPage = queryCategoryRepository.findAll(pageable);

        return categoryListPage.map(this::toDTO);
    }

    private QueryCategoryDTO toDTO(Category category) {
        QueryCategoryDTO dto = new QueryCategoryDTO();
        dto.setCategoryNo(category.getCategoryNo());
        dto.setCountry(category.getCountry());
        dto.setFoodType(category.getFoodType());
        return dto;
    }

    public Category findById(Integer categoryNo) {
        return queryCategoryRepository.findById(categoryNo).orElseThrow(RuntimeException::new);

    }

}
