package com.goalapa.cacamuca.statDomain.query.domain.respository;

import com.goalapa.cacamuca.statDomain.query.application.dto.QueryStatDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GetStatMapper {
    List<QueryStatDTO> findAllStats();
}
