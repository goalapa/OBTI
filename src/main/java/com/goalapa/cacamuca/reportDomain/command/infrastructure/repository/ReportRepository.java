package com.goalapa.cacamuca.reportDomain.command.infrastructure.repository;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.ReportRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepository implements ReportRepositoryImpl {

    @Override
    public void save(Integer reportMemberNo, Integer reportedMemberNo, String reviewNo, Integer reviewType) {
        Report report = new Report();
        report.set
    }
}
