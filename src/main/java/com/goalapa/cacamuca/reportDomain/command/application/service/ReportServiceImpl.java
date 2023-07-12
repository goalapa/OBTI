package com.goalapa.cacamuca.reportDomain.command.application.service;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportedMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.ReportRepository;
import com.goalapa.cacamuca.reportDomain.command.domain.service.ReportService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    // 신고 저장
    @Override
    @Transactional
    public void saveNewReport(ReportDTO reportDTO) {
        ReviewVO reviewVO = new ReviewVO(reportDTO.getReviewNo());
        ReportMemberVO reportMemberVO = new ReportMemberVO(reportDTO.getReportMemberNo());
        ReportedMemberVO reportedMemberVO = new ReportedMemberVO(reportDTO.getReportedMemberNo());

        Report report = new Report(reviewVO, reportMemberVO, reportedMemberVO, reportDTO.getReportType());

        reportRepository.save(report);
    }

    // 블랙 리스트 추가 로직

}
