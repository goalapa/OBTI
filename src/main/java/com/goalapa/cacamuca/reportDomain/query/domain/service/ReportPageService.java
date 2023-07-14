package com.goalapa.cacamuca.reportDomain.query.domain.service;

import com.goalapa.cacamuca.reportDomain.query.application.dto.ReportQueryDTO;
import com.goalapa.cacamuca.reportDomain.query.domain.entity.ReportQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReportPageService {
    Page<ReportQueryDTO> getReportPage(Pageable pageable);
}
