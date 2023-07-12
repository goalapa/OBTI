package com.goalapa.cacamuca.requestDomain.command.infrastructure.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.application.service.SaveRequestServiceImpl;
import com.goalapa.cacamuca.requestDomain.command.domain.service.CheckRequestService;
import org.springframework.stereotype.Service;

@Service
public class CheckRequestServiceImpl implements CheckRequestService {

    private final SaveRequestServiceImpl saveRequestServiceImpl;

    public CheckRequestServiceImpl(SaveRequestServiceImpl saveRequestServiceImpl) {
        this.saveRequestServiceImpl = saveRequestServiceImpl;
    }


    @Override
    public void checkNotNull(RequestDTO requestDTO) {
        if(requestDTO.getRequestContent() != null &&
        requestDTO.getRequestPrice() != null &&
        requestDTO.getRequestedFood() != null &&
        requestDTO.getCountry() != null &&
        requestDTO.getFoodType() != null ) {
            saveRequestServiceImpl.saveRequest(requestDTO);
        }
    }
}
