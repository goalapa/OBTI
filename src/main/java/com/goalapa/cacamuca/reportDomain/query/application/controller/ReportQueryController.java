package com.goalapa.cacamuca.reportDomain.query.application.controller;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.query.application.dto.ReportQueryDTO;
import com.goalapa.cacamuca.reportDomain.query.application.service.ReportPageServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/*")
public class ReportQueryController {

    private final ReportPageServiceImpl reportPageServiceImpl;

    public ReportQueryController(ReportPageServiceImpl reportPageServiceImpl) {
        this.reportPageServiceImpl = reportPageServiceImpl;
    }

    @GetMapping("admin/report")
    public Page<ReportQueryDTO> getReportPage(@PageableDefault(size = 10, sort="report_no", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportQueryDTO> reportList = reportPageServiceImpl.getReportPage(pageable);

        return reportList;
    }
}
