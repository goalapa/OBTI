package com.goalapa.cacamuca.statDomain.query.infrastructure.service;

import com.goalapa.cacamuca.statDomain.query.infrastructure.repository.StatMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberGenderService {

    private final StatMapper statMapper;

    public MemberGenderService(StatMapper statMapper) {
        this.statMapper = statMapper;
    }

    public String getPreferredMemberGender(int foodNo) {
        return statMapper.memberGender(foodNo);
    }
}
