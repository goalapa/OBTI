package com.goalapa.cacamuca.requestDomain.query.domain.repository;

import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestDTO;
import com.goalapa.cacamuca.requestDomain.query.application.dto.FindRequestPicDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RequestMapper {
    List<FindRequestDTO> findAllRequests();
    FindRequestDTO findRequestByRequestNo(int requestNo);
    FindRequestPicDTO findRequestPicByRequestNo(int requestNo);
}
