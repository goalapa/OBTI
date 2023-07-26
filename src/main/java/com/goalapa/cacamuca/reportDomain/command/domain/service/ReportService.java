package com.goalapa.cacamuca.reportDomain.command.domain.service;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportCreateDTO;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDeleteDTO;
import javassist.NotFoundException;

public interface ReportService {

    // 신고 테이블에 저장
    void saveNewReport(ReportCreateDTO reportDTO, String reportMemberId);

    // 신고 테이블에서 삭제
    void deleteReportById(int reportNo) throws NotFoundException;

    // 누적 신고 횟수 추가
    int addReportCount(ReportDeleteDTO reportDeleteDTO);

    // 블랙리스트 저장
    void saveBlackList(Integer reportedMemberNo);

    // 리뷰에 신고 횟수 추가 & 신고 많이 당한 리뷰는 삭제
    void deleteReviewWithReportedCnt(ReportDeleteDTO reportDeleteDTO);
}
