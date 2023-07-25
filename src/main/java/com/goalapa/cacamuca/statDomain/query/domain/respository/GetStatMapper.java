package com.goalapa.cacamuca.statDomain.query.domain.respository;

import com.goalapa.cacamuca.statDomain.query.application.dto.QueryStatDTO;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;
@Mapper
public interface GetStatMapper {
//    List<QueryStatDTO> findAllStats();
//
//    List<QueryStatDTO> findStatsByDate(LocalDate date);
//
//    List<QueryStatDTO> findStatsByDateAndCountry(LocalDate date, String country);

    List<QueryStatDTO> getStatTopTen(LocalDate date, String country);
}
