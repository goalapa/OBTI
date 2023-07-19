package com.goalapa.cacamuca.requestDomain.query.domain.repository;

import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestPicDTO;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface RequestMapper {
    List<FindRequestDTO> findAllRequests();
    FindRequestDTO findRequestByRequestNo(int requestNo);

    FindRequestPicDTO findRequestPicByRequestNo(int requestNo);
}
