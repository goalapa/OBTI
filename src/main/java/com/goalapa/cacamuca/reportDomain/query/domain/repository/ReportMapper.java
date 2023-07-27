package com.goalapa.cacamuca.reportDomain.query.domain.repository;

import com.goalapa.cacamuca.reportDomain.query.application.dto.ReportQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReportMapper {

    List<ReportQueryDTO> getReportPage(Map<String, Object> map);

    int getTotalItems(Pageable pageable);

}
