package com.goalapa.cacamuca.foodDomain.query.application.service;

import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.dto.CheckFoodDTO;
import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.entity.Food;
import com.goalapa.cacamuca.foodDomain.query.domain.repository.FoodRegistMapper;
import com.goalapa.cacamuca.foodDomain.query.domain.service.QueryFoodService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryFoodServiceImpl implements QueryFoodService {

    private final FoodRegistMapper foodRegistMapper;
    private final ModelMapper modelMapper;


    public Page<CheckFoodDTO> findFoodRegistList(Pageable pageable) {

        HashMap<String, Object> map = new HashMap<>();
        Sort sort = pageable.getSort();
        int size = pageable.getPageSize();
        long offset = pageable.getOffset();
        map.put("sort", sort);
        map.put("size", size);
        map.put("offset", offset);

        List<Food> foodRegistList = foodRegistMapper.findFoodsRegist(pageable);
        Integer count = foodRegistMapper.countFoodRegistList();

        List<CheckFoodDTO> foodRegistLists = foodRegistList.stream().map(food -> modelMapper.map(food, CheckFoodDTO.class)).collect(Collectors.toList());

        Page<CheckFoodDTO> page = new PageImpl<>(foodRegistLists, pageable, count);

        return page;
    }

}