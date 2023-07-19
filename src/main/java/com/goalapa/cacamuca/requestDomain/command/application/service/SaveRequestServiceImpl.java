package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestCountry;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestFoodType;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestMemberNo;
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

        RequestCountry requestCountry = new RequestCountry(requestDTO.getRequestCountry());
        RequestFoodType requestFoodType = new RequestFoodType(requestDTO.getRequestFoodType());
        RequestMemberNo requestMemberNo = new RequestMemberNo(requestDTO.getRequestMemberNo());



        Request request = new Request();
        request.setRequestMemberNo(requestMemberNo);
        request.setRequestPrice(requestDTO.getRequestPrice());
        request.setRequestFoodType(requestFoodType);
        request.setRequestCountry(requestCountry);
        request.setRequestedFood(requestDTO.getRequestedFood());
        request.setRequestContent(requestDTO.getRequestContent());


        System.out.println("request = " + request);
        requestRepository.save(request);

    }
}
