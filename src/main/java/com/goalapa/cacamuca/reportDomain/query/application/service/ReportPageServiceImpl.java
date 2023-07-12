package com.goalapa.cacamuca.reportDomain.query.application.service;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import com.goalapa.cacamuca.reportDomain.query.domain.service.ReportPageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReportPageServiceImpl implements ReportPageService {
    @Override
    public Page<Report> findAllReport(Pageable pageable) {
        return null;
    }
}
