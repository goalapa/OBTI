package com.goalapa.cacamuca.requestDomain.command.infrastructure.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestPicDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.service.CheckRequestPic;
import org.springframework.stereotype.Service;

@Service
public class CheckRequestPicServiceImpl implements CheckRequestPic {
    @Override
    public void checkNotNull(RequestPicDTO requestPicDTO) {

    }
}
