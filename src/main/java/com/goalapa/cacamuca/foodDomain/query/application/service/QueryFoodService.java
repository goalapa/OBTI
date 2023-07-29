package com.goalapa.cacamuca.foodDomain.query.application.service;

import com.goalapa.cacamuca.foodDomain.command.application.dto.FoodPicDTO;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.entity.FoodEntity;
import com.goalapa.cacamuca.foodDomain.command.domain.aggregate.vo.CountryVO;
import com.goalapa.cacamuca.foodDomain.query.domain.repository.FoodRegistMapper;
import com.goalapa.cacamuca.foodDomain.query.domain.repository.QueryFoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service(value = "QueryApplicationFoodService")
public class QueryFoodService {

    private final FoodRegistMapper foodRegistMapper;
    private final QueryFoodRepo queryFoodRepo;


    public Page<FoodEntity> findFoodByCountry(Pageable pageable, String country) {

        CountryVO countryVO = new CountryVO(country);

        return queryFoodRepo.findByCountryVO(pageable, countryVO);
    }

    public List<FoodPicDTO> findAllFoodPic() {

        return foodRegistMapper.findAllFoodPic();
    }
}
