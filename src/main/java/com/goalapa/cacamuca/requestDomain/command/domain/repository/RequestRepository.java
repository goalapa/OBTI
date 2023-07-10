package com.goalapa.cacamuca.requestDomain.command.domain.repository;

import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.Request;

public interface RequestRepository {
    Request findByRequestNumber(int requestNumber);

}
