package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.requestDomain.command.domain.repository.RequestPicRepository;
import com.goalapa.cacamuca.requestDomain.command.domain.service.DeleteRequestPic;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DeleteRequestPicImpl implements DeleteRequestPic {

    private final RequestPicRepository requestPicRepository;

    public DeleteRequestPicImpl(RequestPicRepository requestPicRepository) {
        this.requestPicRepository = requestPicRepository;
    }


    @Override
    @Transactional
    public void deleteRequestPic(int requestNo) {
        requestPicRepository.deleteById(requestNo);
    }
}
