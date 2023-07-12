package com.goalapa.cacamuca.reportDomain.command.application.service;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
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
        Report report = new Report(reportDTO.getReportMemberNo(), reportDTO.getReportedMemberNo(),
                reportDTO.getReviewNo(), reportDTO.getReportType());

        reportRepository.save(report);
    }

    // 블랙 리스트 추가 로직

}
