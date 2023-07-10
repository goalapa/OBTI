package com.goalapa.cacamuca.requestDomain.command.infrastructure.repository;

import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;
import com.goalapa.cacamuca.requestDomain.command.domain.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RequestRepositoryImpl implements RequestRepository{

    private Request request;

    @Override
    public Request findByRequestNumber(int requestNumber) {
        return null;
    }


}
