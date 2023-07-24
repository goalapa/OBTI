package com.goalapa.cacamuca.statDomain.query.infrastructure.service;

import com.goalapa.cacamuca.statDomain.query.domain.respository.StatMapper;
import org.springframework.stereotype.Service;

@Service
public class ReviewCntService {

    private final StatMapper statMapper;

    public ReviewCntService(StatMapper statMapper) {
        this.statMapper = statMapper;
    }

    public int countReviews(int foodNo) {
        return statMapper.countReviews(foodNo);
    }
}
