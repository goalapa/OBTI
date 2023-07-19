package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.foodDomain.command.domain.repository.FoodRepository;
import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestCountry;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestFoodType;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestMemberNo;
import com.goalapa.cacamuca.requestDomain.command.domain.service.SaveRequestToFood;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SaveRequestToFoodImpl implements SaveRequestToFood {

    private final FoodRepository foodRepository;

    public SaveRequestToFoodImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    @Transactional
    public void saveRequestToFood(FindRequestDTO findRequestDTO) {

        //foodDTO 완성 후 저장 기능 추가

    }
}
