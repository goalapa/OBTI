package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.command.domain.repository.RequestRepository;
import com.goalapa.cacamuca.requestDomain.command.domain.service.SaveRequestService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class SaveRequestServiceImpl implements SaveRequestService {

    private static RequestRepository requestRepository;
    @Override
    @Transactional
    public void saveRequest(RequestDTO requestDTO) {

        Request request = new Request(requestDTO.getRequestedFood(), requestDTO.getRequestPrice(),
                requestDTO.getMemberNo(), requestDTO.getCountry(), requestDTO.getFoodType(), requestDTO.getRequestContent());

        requestRepository.save(request);

    }
}
