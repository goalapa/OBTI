package com.goalapa.cacamuca.appreviewDomain.query.domain.repository;

import com.goalapa.cacamuca.appreviewDomain.command.application.dto.AppReviewDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FindAppMapper {
    Float findAvgAppReviewRate();
}
