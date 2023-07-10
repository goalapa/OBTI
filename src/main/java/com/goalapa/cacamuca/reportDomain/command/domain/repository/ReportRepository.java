package com.goalapa.cacamuca.reportDomain.command.domain.repository;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;

public interface ReportRepository {
    // 신고 테이블에 저장
    void save(ReportDTO reportDTO);
}
