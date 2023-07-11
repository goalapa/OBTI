package com.goalapa.cacamuca.requestDomain.command.domain.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;

public interface SaveRequestService {

    void addNewRequest(RequestDTO requestDTO);
}
