package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.requestDomain.command.domain.repository.RequestRepository;
import com.goalapa.cacamuca.requestDomain.command.domain.service.DeleteRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DeleteRequestImpl implements DeleteRequest {

    private final RequestRepository requestRepository;

    public DeleteRequestImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    @Transactional
    public void deleteRequest(int requestNo) {
        requestRepository.deleteById(requestNo);
    }
}
