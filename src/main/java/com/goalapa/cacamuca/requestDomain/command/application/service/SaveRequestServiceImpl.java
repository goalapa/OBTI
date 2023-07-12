package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.command.domain.repository.RequestRepository;
import com.goalapa.cacamuca.requestDomain.command.domain.service.SaveRequestService;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class SaveRequestServiceImpl implements SaveRequestService {

    private final RequestRepository requestRepository;

    public SaveRequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    @Transactional
    public void saveRequest(RequestDTO requestDTO) {

        Request request = new Request(requestDTO.getRequestedFood(), requestDTO.getRequestPrice(),
                requestDTO.getMemberNo(), requestDTO.getCountry(), requestDTO.getFoodType(), requestDTO.getRequestContent());

        System.out.println("request = " + request);

        requestRepository.save(request);

    }
}
