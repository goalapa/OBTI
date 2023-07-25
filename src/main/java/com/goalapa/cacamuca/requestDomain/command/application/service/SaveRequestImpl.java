package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.memberDomain.command.application.dto.CustomUser;
import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity.Member;
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
    public void saveRequest(RequestDTO requestDTO, int user) {

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

        requestRepository.save(request);

    }

}
