package com.goalapa.cacamuca.appreviewDomain.query.application.service;

import com.goalapa.cacamuca.appreviewDomain.command.domain.aggregate.entity.AppReview;
import com.goalapa.cacamuca.appreviewDomain.query.domain.repository.FindAppMapper;
import com.goalapa.cacamuca.appreviewDomain.query.domain.repository.FindAppReviewRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindAppReviewService {

    private final FindAppReviewRepo findAppReviewRepo;
    private final FindAppMapper findAppMapper;

    public FindAppReviewService(FindAppReviewRepo findAppReviewRepo, FindAppMapper findAppMapper) {
        this.findAppReviewRepo = findAppReviewRepo;
        this.findAppMapper = findAppMapper;
    }

    public Page<AppReview> findAllAppReview(Pageable pageable) {

        return findAppReviewRepo.findAll(pageable);
    }

    public Float findAvgAppReviewRate() {
        System.out.println("findAppMapper = " + findAppMapper.findAvgAppReviewRate());
        return findAppMapper.findAvgAppReviewRate();
    }
}
