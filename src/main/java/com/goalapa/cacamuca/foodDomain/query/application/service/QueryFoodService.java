package com.goalapa.cacamuca.foodDomain.query.application.service;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodPicDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodEntity;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.CountryVO;
import com.goalapa.cacamuca.foodDomain.query.application.dto.QueryFoodDTO;
import com.goalapa.cacamuca.foodDomain.query.domain.aggregate.entity.Food;
import com.goalapa.cacamuca.foodDomain.query.domain.repository.FoodRegistMapper;
import com.goalapa.cacamuca.foodDomain.query.domain.repository.QueryFoodRepo;
import com.goalapa.cacamuca.foodDomain.query.infrastructure.repository.FoodMapper;
import com.goalapa.cacamuca.foodDomain.query.infrastructure.repository.QueryFoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;


@RequiredArgsConstructor
@Service(value = "QueryApplicationFoodService")
public class QueryFoodService {

    private final FoodRegistMapper foodRegistMapper;
    private final QueryFoodRepo queryFoodRepo;
    private final QueryFoodRepository queryFoodRepository;
    private final FoodMapper foodMapper;


    public Page<FoodEntity> findFoodByCountry(Pageable pageable, String country) {

        CountryVO countryVO = new CountryVO(country);

        return queryFoodRepo.findByCountryVO(pageable, countryVO);
    }

    public List<FoodPicDTO> findAllFoodPic() {

        return foodRegistMapper.findAllFoodPic();
    }

    public List<QueryFoodDTO> findAllFood() {

        return foodMapper.findAllFood();
    }

    public Page<QueryFoodDTO> getFoodList(int pageNo, int pageSize, String sortBy) {

        int pageNumber = pageNo - 1;
        Sort sort = Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Food> foodListPage = queryFoodRepository.findAll(pageable);

        return foodListPage.map(this::toDTO);
    }

    private QueryFoodDTO toDTO(Food food) {
        QueryFoodDTO dto = new QueryFoodDTO();
        dto.setFoodNo(food.getFoodNo());
        dto.setFoodName(food.getFoodName());
        dto.setFoodType(food.getFoodType());
        dto.setFoodRate(food.getFoodRate());
        dto.setFoodPrice(food.getFoodPrice());
        dto.setCountry(food.getCountry());
        return dto;
    }

    public Food findById(Integer foodNo) {
        return queryFoodRepository.findById(foodNo).orElseThrow(RuntimeException::new);
    }
}
