package com.goalapa.cacamuca.requestDomain.query.application.service;

import com.goalapa.cacamuca.requestDomain.command.application.dto.RequestDTO;
import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import com.goalapa.cacamuca.requestDomain.query.domain.repository.FindRequestRepository;
import com.goalapa.cacamuca.requestDomain.query.domain.repository.RequestMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindRequestService {

    private final RequestMapper requestMapper;
    private final FindRequestRepository findRequestRepository;

    public FindRequestService(RequestMapper requestMapper, FindRequestRepository findRequestRepository) {
        this.requestMapper = requestMapper;
        this.findRequestRepository = findRequestRepository;
    }


    public Page<Request> findAllRequest(Pageable pageable) {

        return findRequestRepository.findAll(pageable);
    }



    public FindRequestDTO findRequestByRequestNo(int requestNo) {

        FindRequestDTO request = requestMapper.findRequestByRequestNo(requestNo);
        return request;
    }

}
