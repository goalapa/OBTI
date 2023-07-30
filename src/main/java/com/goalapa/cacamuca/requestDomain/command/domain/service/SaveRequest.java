package com.goalapa.cacamuca.requestDomain.command.domain.service;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;

public interface SaveRequest {

    int saveRequest(RequestDTO requestDTO, int memberNo);
}
