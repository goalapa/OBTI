package com.goalapa.cacamuca.requestDomain.query.application.service;

import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import com.goalapa.cacamuca.requestDomain.query.domain.repository.RequestMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindRequestService {

    private final RequestMapper requestMapper;

    public FindRequestService(RequestMapper requestMapper) {
        this.requestMapper = requestMapper;
    }

    public List<FindRequestDTO> findAllRequestService() {

       List<FindRequestDTO> requests = requestMapper.findAllRequests();
        return requests;
    }


    public FindRequestDTO findRequestByRequestNo(int requestNo) {

        FindRequestDTO request = requestMapper.findRequestByRequestNo(requestNo);
        return request;
    }
}
