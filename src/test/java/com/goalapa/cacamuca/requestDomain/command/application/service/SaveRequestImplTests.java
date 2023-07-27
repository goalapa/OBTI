package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.repository.RequestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.transaction.Transactional;


@SpringBootTest
@Transactional
public class SaveRequestImplTests {

    @Autowired
    private SaveRequestImpl saveRequestImpl;

    @Autowired
    private RequestRepository requestRepository;

    @DisplayName("새로운 요청 추가 테스트")
    @Test
    void testSaveRequest() {

        long beforeSize = requestRepository.count();

        String requestFood = "테스트 요청 식품";
        int requestPrice = 10000;
        int requestMemberNo = 1;
        String requestCountry = "한국";
        String requestFoodType = "과자";
        String requestContent = "테스트 요청 식품 content 입니다.";

        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setRequestFood(requestFood);
        requestDTO.setRequestPrice(requestPrice);
        requestDTO.setRequestCountry(requestCountry);
        requestDTO.setRequestFoodType(requestFoodType);
        requestDTO.setRequestContent(requestContent);

        saveRequestImpl.saveRequest(requestDTO, requestMemberNo);

        long afterSize = requestRepository.count();

        Assertions.assertEquals(beforeSize + 1, afterSize);

    }
}
