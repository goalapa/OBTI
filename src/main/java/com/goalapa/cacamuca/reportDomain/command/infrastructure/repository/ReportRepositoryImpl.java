package com.goalapa.cacamuca.reportDomain.command.infrastructure.repository;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepositoryImpl implements com.goalapa.cacamuca.reportDomain.command.domain.repository.ReportRepository {

    @Override
    public void save(ReportDTO reportDTO) {
        Report report = new Report();
    }

}
