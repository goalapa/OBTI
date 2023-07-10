package com.goalapa.cacamuca.reportDomain.command.domain.service;

public interface ReportServiceImpl {
    boolean checkNotNull(Integer reportedMemberNo, Integer reportMemberNo, String reviewNo);

    void saveReportService(Integer reportedMemberNo, Integer reportMemberNo, String reviewNo, Integer reviewType);
}
