package com.goalapa.cacamuca.statDomain.command.domain.aggregate.service;

import com.goalapa.cacamuca.statDomain.command.application.dto.StatDTO;

public interface SaveStatService {

    void insertData(StatDTO statDTO);
}
