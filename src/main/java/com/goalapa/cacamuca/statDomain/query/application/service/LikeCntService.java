package com.goalapa.cacamuca.statDomain.query.application.service;

import com.goalapa.cacamuca.statDomain.query.domain.respository.StatMapper;
import org.springframework.stereotype.Service;

@Service
public class LikeCntService {

    private final StatMapper statMapper;

    public LikeCntService(StatMapper statMapper) {
        this.statMapper = statMapper;
    }

    public int countLikes(int foodNo) {
        return statMapper.countLikes(foodNo);
    }
}
