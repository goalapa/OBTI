package com.goalapa.cacamuca.reportDomain.command.domain.service;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDeleteDTO;
import javassist.NotFoundException;

public interface ReportService {

    // 신고 테이블에 저장
    void saveNewReport(ReportDTO reportDTO);

    // 신고 테이블에서 삭제
    void deleteReportById(int reportNo) throws NotFoundException;

    // 누적 신고 횟수 추가
    int addReportCount(ReportDeleteDTO reportDeleteDTO);

    void saveBlackList(Integer reportedMemberNo);
}
