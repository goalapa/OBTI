package com.goalapa.cacamuca.statDomain.command.application.service;

import com.goalapa.cacamuca.statDomain.command.application.dto.StatDTO;
import com.goalapa.cacamuca.statDomain.command.domain.aggregate.repository.StatRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;

@SpringBootTest
@Transactional
public class SaveStatServiceImplTests{

    @Autowired
    private SaveStatServiceImpl saveStatServiceImpl;

    @Autowired
    private StatRepository statRepository;

    @DisplayName("통계 자료 저장 테스트")
    @Test
    void testSaveStatData() {

        long beforeSize = statRepository.count();


        StatDTO stat = new StatDTO();
        stat.setFoodName("테스트식품");
        stat.setUpdateDate(LocalDate.now());
        stat.setFoodRate(3.5F);
        stat.setMemberAgeGroup(10);
        stat.setLikeCnt(200);
        stat.setReviewCnt(100);
        stat.setCountry("한국");

        saveStatServiceImpl.insertData(stat);

        long afterSize = statRepository.count();

        Assertions.assertEquals(beforeSize + 1, afterSize);

    }
}
