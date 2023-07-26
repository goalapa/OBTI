package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.repository.RequestRepository;
import com.goalapa.cacamuca.statDomain.command.application.dto.StatDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class DeleteRequestImplTests {

    @Autowired
    private DeleteRequestImpl deleteRequestImpl;

    @Autowired
    private RequestRepository requestRepository;
    @DisplayName("요청 삭제 테스트")
    @Test
    void testDeleteRequest() {

        long beforeSize = requestRepository.count();

        deleteRequestImpl.deleteRequest(1);

        long afterSize = requestRepository.count();

        Assertions.assertEquals(beforeSize - 1, afterSize);

    }
}
