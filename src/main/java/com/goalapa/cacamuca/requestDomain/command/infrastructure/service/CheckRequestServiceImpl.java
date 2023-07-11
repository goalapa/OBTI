package com.goalapa.cacamuca.requestDomain.command.infrastructure.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import org.springframework.stereotype.Service;

@Service
public class CheckRequestServiceImpl implements CheckRequestService {

    private RequestDTO requestDTO;


    @Override
    public void checkNotNull(RequestDTO requestDTO) {

    }
}
