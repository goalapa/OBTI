package com.goalapa.cacamuca.reportDomain.command.domain.service;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;

public interface ReportService {

    // 신고 테이블에 저장
    void saveNewReport(ReportDTO reportDTO);

    // 블랙 리스트 저장
}
