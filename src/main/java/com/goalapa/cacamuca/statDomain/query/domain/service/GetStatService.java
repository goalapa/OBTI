package com.goalapa.cacamuca.statDomain.query.domain.service;

import com.goalapa.cacamuca.statDomain.command.application.service.StatScheduler;
import com.goalapa.cacamuca.statDomain.query.application.dto.QueryStatDTO;
import com.goalapa.cacamuca.statDomain.query.domain.respository.GetStatMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GetStatService {

    private final GetStatMapper getStatMapper;



    public GetStatService(GetStatMapper getStatMapper) {
        this.getStatMapper = getStatMapper;
    }

    public List<QueryStatDTO> findAllStats() {
        return getStatMapper.findAllStats();
    }

    public List<QueryStatDTO> findStatsByDate(LocalDate date) {
        return getStatMapper.findStatsByDate(date);
    }

    public List<QueryStatDTO> findStatsByDateAndCountry(LocalDate date, String country) {
        return getStatMapper.findStatsByDateAndCountry(date, country);
    }
}
