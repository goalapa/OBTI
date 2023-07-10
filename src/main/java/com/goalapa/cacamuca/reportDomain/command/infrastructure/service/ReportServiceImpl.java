package com.goalapa.cacamuca.reportDomain.command.infrastructure.service;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.infrastructure.repository.ReportRepositoryImpl;
import org.springframework.stereotype.Service;


@Service
public class ReportServiceImpl implements com.goalapa.cacamuca.reportDomain.command.domain.service.ReportService {

    private final ReportRepositoryImpl reportRepositoryImpl;

    public ReportServiceImpl(ReportRepositoryImpl reportRepositoryImpl) {
        this.reportRepositoryImpl = reportRepositoryImpl;
    }

    // 신고자, 피신고자, 리뷰가 null이 아닌지 확인하는 로직 추가
    @Override
    public boolean checkNotNull(ReportDTO reportDTO) {
        return false;
    }

    @Override
    public void saveNewReport(ReportDTO reportDTO) {
        System.out.println(reportDTO.toString());

        reportRepositoryImpl.save(reportDTO);
    }
}
