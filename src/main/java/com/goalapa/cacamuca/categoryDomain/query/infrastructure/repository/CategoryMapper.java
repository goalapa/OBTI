package com.goalapa.cacamuca.categoryDomain.query.infrastructure.repository;


import com.goalapa.cacamuca.categoryDomain.query.application.dto.QueryCategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<QueryCategoryDTO> findAllCategory();


}
