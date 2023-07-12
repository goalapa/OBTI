package com.goalapa.cacamuca.reportDomain.query.application.controller;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity.Report;
import com.goalapa.cacamuca.reportDomain.query.application.service.ReportPageServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class ReportController {

    private final ReportPageServiceImpl reportPageServiceImpl;

    public ReportController(ReportPageServiceImpl reportPageServiceImpl) {
        this.reportPageServiceImpl = reportPageServiceImpl;
    }

    @GetMapping("admin/report")
    public Page<Report> getReportPage(Model model, @PageableDefault(size = 10, sort="report_no", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Report> reportList = reportPageServiceImpl.findAllReport(pageable);

        //model.addAttribute("reportList", reportPageServiceImpl.findAllReport(pageable));

        return reportList;
    }
}
