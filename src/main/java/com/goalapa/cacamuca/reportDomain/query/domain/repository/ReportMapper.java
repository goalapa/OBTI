package com.goalapa.cacamuca.reportDomain.query.domain.repository;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {

    List<ReportDTO> findAllReport(@Param("offset") int offset, @Param("limit") int limit);

}
