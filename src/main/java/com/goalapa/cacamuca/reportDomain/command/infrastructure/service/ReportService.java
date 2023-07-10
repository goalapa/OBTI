package com.goalapa.cacamuca.reportDomain.command.infrastructure.service;

import com.goalapa.cacamuca.reportDomain.command.domain.service.ReportServiceImpl;
import com.goalapa.cacamuca.reportDomain.command.infrastructure.repository.ReportRepository;
import org.springframework.stereotype.Service;


@Service
public class ReportService implements ReportServiceImpl {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public boolean checkNotNull(Integer reportedMemberNo, Integer reportMemberNo, String reviewNo) {
        return false;
    }

    @Override
    public void saveReportService(Integer reportedMemberNo, Integer reportMemberNo, String reviewNo, Integer reviewType) {
        reportRepository.save(reportMemberNo, reportedMemberNo, reviewNo, reviewType);
    }
}
