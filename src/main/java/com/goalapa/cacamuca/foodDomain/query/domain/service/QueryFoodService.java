package com.goalapa.cacamuca.foodDomain.query.domain.service;

import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.dto.CheckFoodDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QueryFoodService {

    Page<CheckFoodDTO> findFoodRegistList(Pageable pageable);

}
