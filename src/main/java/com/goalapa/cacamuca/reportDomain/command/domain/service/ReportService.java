package com.goalapa.cacamuca.reportDomain.command.domain.service;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import javassist.NotFoundException;

import javax.transaction.Transactional;

public interface ReportService {

    // 신고 테이블에 저장
    void saveNewReport(ReportDTO reportDTO);

    // 신고 테이블에서 삭제
    void deleteReportById(int reportNo) throws NotFoundException;

    @Transactional
    int addReportCount(ReportDTO reportDTO);

}
