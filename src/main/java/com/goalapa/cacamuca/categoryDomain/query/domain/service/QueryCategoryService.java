package com.goalapa.cacamuca.categoryDomain.query.domain.service;

import com.goalapa.cacamuca.categoryDomain.query.domain.aggregate.dto.CategoryListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface QueryCategoryService {


    Page<CategoryListDTO> findQueryCategoryList(Pageable pageable);
}
