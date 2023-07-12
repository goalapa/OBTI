package com.goalapa.cacamuca.reportDomain.query.domain.service;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReportPageService {
    Page<Report> findAllReport(Pageable pageable);
}
