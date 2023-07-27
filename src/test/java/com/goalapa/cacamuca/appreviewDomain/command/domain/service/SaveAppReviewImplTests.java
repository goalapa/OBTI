package com.goalapa.cacamuca.appreviewDomain.command.domain.service;

import com.goalapa.cacamuca.appreviewDomain.command.application.dto.AppReviewDTO;
import com.goalapa.cacamuca.appreviewDomain.command.domain.aggregate.entity.AppReview;
import com.goalapa.cacamuca.appreviewDomain.command.domain.repository.AppReviewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class SaveAppReviewImplTests {

    @Autowired
    private SaveAppReviewImpl saveAppReviewImpl;

    @Autowired
    private AppReviewRepository appReviewRepository;

    @DisplayName("새로운 앱 리뷰 추가 테스트")
    @Test
    void testSaveAppReview() {

        long beforeSize = appReviewRepository.count();

        AppReviewDTO appReview = new AppReviewDTO();
        appReview.setAppReviewContent("test");
        appReview.setAppReviewRate(5.0F);

        saveAppReviewImpl.saveAppReview(appReview, 1,"초코맛있다");

        long afterSize = appReviewRepository.count();

        Assertions.assertEquals(beforeSize + 1, afterSize);

    }
}
