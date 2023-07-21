package com.goalapa.cacamuca.reportDomain.query.domain.repository;

import com.goalapa.cacamuca.reportDomain.query.application.dto.BlackListQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface BlackListMapper {
    List<BlackListQueryDTO> getBlackListPage(Pageable pageable);

    int getTotalItems(Pageable pageable);
}
