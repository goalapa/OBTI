package com.goalapa.cacamuca.requestDomain.command.domain.service;


import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;

public interface CheckRequestService {

    void checkNotNull(RequestDTO requestDTO);
}
