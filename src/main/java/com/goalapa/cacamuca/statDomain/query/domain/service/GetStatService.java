package com.goalapa.cacamuca.statDomain.query.domain.service;

import com.goalapa.cacamuca.statDomain.command.domain.aggregate.entity.Stat;
import com.goalapa.cacamuca.statDomain.query.application.dto.QueryStatDTO;
import com.goalapa.cacamuca.statDomain.query.domain.respository.GetStatMapper;
import com.goalapa.cacamuca.statDomain.query.domain.respository.QueryStatRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GetStatService {

    private final GetStatMapper getStatMapper;
    private final QueryStatRepository queryStatRepository;



    public GetStatService(GetStatMapper getStatMapper, QueryStatRepository queryStatRepository) {
        this.getStatMapper = getStatMapper;
        this.queryStatRepository = queryStatRepository;
    }

    public Page<Stat> findAllStats(Pageable pageable) {

        return queryStatRepository.findAll(pageable);
    }


    public Page<Stat> findStatsByDate(LocalDate date, Pageable pageable) {
        return queryStatRepository.findByUpdateDate(date, pageable);
    }

    public Page<Stat> findStatsByDateAndCountry(LocalDate date, String country, Pageable pageable) {
        return queryStatRepository.findByUpdateDateAndCountry(date, country, pageable);
    }

//    public List<QueryStatDTO> findStatsByDate(LocalDate date) {
//        return getStatMapper.findStatsByDate(date);
//    }
//
//    public List<QueryStatDTO> findStatsByDateAndCountry(LocalDate date, String country) {
//        return getStatMapper.findStatsByDateAndCountry(date, country);
//    }

    public List<QueryStatDTO> getStatTopTen(LocalDate date, String country) {
        return getStatMapper.getStatTopTen(date, country);
    }
}
