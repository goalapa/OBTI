package com.goalapa.cacamuca.appreviewDomain.command.domain.service;

import com.goalapa.cacamuca.appreviewDomain.command.domain.aggregate.entity.AppReview;
import com.goalapa.cacamuca.appreviewDomain.command.domain.repository.AppReviewRepository;
import com.goalapa.cacamuca.appreviewDomain.command.infrastructure.service.SaveAppReview;
import com.goalapa.cacamuca.appreviewDomain.command.application.dto.AppReviewDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SaveAppReviewImpl implements SaveAppReview {

    private final AppReviewRepository appReviewRepository;

    public SaveAppReviewImpl(AppReviewRepository appReviewRepository) {
        this.appReviewRepository = appReviewRepository;
    }

    @Override
    @Transactional
    public void saveAppReview(AppReviewDTO appReviewDTO, int memberNo, String memberNickname) {

        AppReview appReview = new AppReview();
        appReview.setMemberNo(memberNo);
        appReview.setMemberNickname(memberNickname);
        appReview.setAppReviewRate(appReviewDTO.getAppReviewRate()/2);
        appReview.setAppReviewContent(appReviewDTO.getAppReviewContent());

        appReviewRepository.save(appReview);
    }
}
