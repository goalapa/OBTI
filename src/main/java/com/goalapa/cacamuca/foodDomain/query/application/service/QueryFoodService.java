package com.goalapa.cacamuca.foodDomain.query.application.service;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodRepository;
import com.goalapa.cacamuca.foodDomain.query.application.dto.Dto;
import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.dto.CheckFoodDTO;
import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.entity.Food;
import com.goalapa.cacamuca.foodDomain.query.domain.repository.FoodRegistMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service(value = "QueryApplicationFoodService")
public class QueryFoodService {

    private final FoodRegistMapper foodRegistMapper;
    private final FoodRepository foodRepository;
    private final ModelMapper modelMapper;


    public Page<CheckFoodDTO> findFoodList(Pageable pageable) {

        HashMap<String, Object> map = new HashMap<>();
        Sort sort = pageable.getSort();
        int size = pageable.getPageSize();
        long offset = pageable.getOffset();
        map.put("sort", sort);
        map.put("size", size);
        map.put("offset", offset);

        List<Food> foodList = foodRegistMapper.findFoods(pageable);
        Integer count = foodRegistMapper.countFoods();

        List<CheckFoodDTO> checkFoodDTOList = foodList.stream().map(
                food ->
                        modelMapper.map(food, CheckFoodDTO.class)
        ).collect(
                Collectors.toList()
        );


        Page<CheckFoodDTO> page = new PageImpl<>(checkFoodDTOList, pageable, count);

        return page;

    }
}
