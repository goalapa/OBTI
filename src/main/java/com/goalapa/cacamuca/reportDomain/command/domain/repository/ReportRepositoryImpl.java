package com.goalapa.cacamuca.reportDomain.command.domain.repository;

public interface ReportRepositoryImpl {
    void save(Integer reportMemberNo, Integer reportedMemberNo, String reviewNo, Integer reviewType);
}
