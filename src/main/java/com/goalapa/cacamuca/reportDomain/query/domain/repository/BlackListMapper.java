package com.goalapa.cacamuca.reportDomain.query.domain.repository;

import com.goalapa.cacamuca.reportDomain.query.application.dto.BlackListQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

@Mapper
public interface BlackListMapper {
    List<BlackListQueryDTO> getBlackListPage(Map<String, Object> map);

    int getTotalItems(Pageable pageable);
}
