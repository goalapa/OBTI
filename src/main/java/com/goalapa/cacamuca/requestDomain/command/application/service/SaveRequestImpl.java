package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestCountry;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestFoodType;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.vo.RequestMemberNo;
import com.goalapa.cacamuca.requestDomain.command.domain.repository.RequestRepository;
import com.goalapa.cacamuca.requestDomain.command.domain.service.SaveRequest;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class SaveRequestImpl implements SaveRequest {

    private final RequestRepository requestRepository;

    public SaveRequestImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    @Transactional
    public int saveRequest(RequestDTO requestDTO, int user) {

        RequestCountry requestCountry = new RequestCountry(requestDTO.getRequestCountry());
        RequestFoodType requestFoodType = new RequestFoodType(requestDTO.getRequestFoodType());
        RequestMemberNo requestMemberNo = new RequestMemberNo(user);

        Request request = new Request();
        request.setRequestMemberNo(requestMemberNo);
        request.setRequestPrice(requestDTO.getRequestPrice());
        request.setRequestFoodType(requestFoodType);
        request.setRequestCountry(requestCountry);
        request.setRequestFood(requestDTO.getRequestFood());
        request.setRequestContent(requestDTO.getRequestContent());

        Request request1 = new Request();
        System.out.println("request1 = " + request1.getRequestNo());

        requestRepository.save(request);

        return request.getRequestNo();

    }

}
