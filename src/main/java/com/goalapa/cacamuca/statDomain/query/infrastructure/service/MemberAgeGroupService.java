package com.goalapa.cacamuca.statDomain.query.infrastructure.service;

import com.goalapa.cacamuca.statDomain.query.infrastructure.repository.StatMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberAgeGroupService {
    private final StatMapper statMapper;


    public MemberAgeGroupService(StatMapper statMapper) {
        this.statMapper = statMapper;
    }

    public int returnMemberAgeGroup(int foodNo) {

        return statMapper.memberAgeGroup(foodNo);
    }
}
