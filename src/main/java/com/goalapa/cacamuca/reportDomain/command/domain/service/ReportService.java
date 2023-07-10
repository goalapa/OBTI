package com.goalapa.cacamuca.reportDomain.command.domain.service;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;

public interface ReportService {

    // 신고자, 피신고자, 리뷰가 null이 아닌지 확인
    boolean checkNotNull(ReportDTO reportDTO);

    // 신고 테이블에 저장
    void saveNewReport(ReportDTO reportDTO);

}
