package com.goalapa.cacamuca.statDomain.query.infrastructure.service;

import com.goalapa.cacamuca.statDomain.query.infrastructure.repository.StatMapper;
import org.springframework.stereotype.Service;

@Service
public class FoodRateService {
    private final StatMapper statMapper;

    public FoodRateService(StatMapper statMapper) {
        this.statMapper = statMapper;
    }

    public float calculateFoodRate(int foodNo) {
        return statMapper.calculateFoodRate(foodNo);
    }
}
