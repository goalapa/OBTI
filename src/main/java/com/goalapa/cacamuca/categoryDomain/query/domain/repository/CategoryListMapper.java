package com.goalapa.cacamuca.categoryDomain.query.domain.repository;

import com.goalapa.cacamuca.categoryDomain.query.domain.aggregate.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface CategoryListMapper {


    List<Category> findCategories(Pageable pageable);

    Integer countCategories();
}
