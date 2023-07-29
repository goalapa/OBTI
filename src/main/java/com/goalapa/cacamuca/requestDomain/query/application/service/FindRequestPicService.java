package com.goalapa.cacamuca.requestDomain.query.application.service;

import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestPicDTO;
import com.goalapa.cacamuca.requestDomain.query.domain.repository.RequestMapper;
import org.springframework.stereotype.Service;

@Service
public class FindRequestPicService {

    private final RequestMapper requestMapper;
    public FindRequestPicService(RequestMapper requestMapper) {
        this.requestMapper = requestMapper;
    }


    public FindRequestPicDTO findRequestPicByRequestNo(int requestNo) {

        FindRequestPicDTO request = requestMapper.findRequestPicByRequestNo(requestNo);

        return request;
    }
}
