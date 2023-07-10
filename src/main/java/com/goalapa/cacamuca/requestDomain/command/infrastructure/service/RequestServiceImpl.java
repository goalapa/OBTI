package com.goalapa.cacamuca.requestDomain.command.infrastructure.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.command.domain.service.RequestService;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    private RequestDTO requestDTO;

    @Override
    public void addNewRequest(RequestDTO requestDTO) {
        System.out.println("requestDTO = " + requestDTO); //INSERT
    }
}
