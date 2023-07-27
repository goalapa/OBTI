package com.goalapa.cacamuca.appreviewDomain.command.infrastructure.service;

import com.goalapa.cacamuca.appreviewDomain.command.application.dto.AppReviewDTO;

import javax.transaction.Transactional;

public interface SaveAppReview {

    @Transactional
    void saveAppReview(AppReviewDTO appReviewDTO, int memberNo, String memberNickname);
}
