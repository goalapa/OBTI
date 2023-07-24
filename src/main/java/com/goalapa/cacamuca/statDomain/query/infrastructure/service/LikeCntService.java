package com.goalapa.cacamuca.statDomain.query.infrastructure.service;

import com.goalapa.cacamuca.statDomain.query.infrastructure.repository.StatMapper;
import org.springframework.stereotype.Service;

@Service
public class LikeCntService {

    private final StatMapper statMapper;

    public LikeCntService(StatMapper statMapper) {
        this.statMapper = statMapper;
    }

    public Integer countLikes(int foodNo) {
        return statMapper.countLikes(foodNo);
    }
}
