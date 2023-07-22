package com.goalapa.cacamuca.reviewDomain.command.domain.service;

import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewValidationService {
    boolean checkCondition(Review review, Integer no, Integer memberNo);

}
