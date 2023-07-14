package com.goalapa.cacamuca.reportDomain.query.application.controller;

import com.goalapa.cacamuca.reportDomain.query.application.dto.ReportQueryDTO;
import com.goalapa.cacamuca.reportDomain.query.application.service.ReportPageServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin-page")
public class ReportQueryController {

    private final ReportPageServiceImpl reportPageServiceImpl;

    public ReportQueryController(ReportPageServiceImpl reportPageServiceImpl) {
        this.reportPageServiceImpl = reportPageServiceImpl;
    }

    @GetMapping("/report")
    public String getReportPage(@PageableDefault(size = 5, sort="report_no", direction = Sort.Direction.DESC) Pageable pageable) {
        int totalPages = reportPageServiceImpl.getTotalPages(pageable.getPageSize());
        Page<ReportQueryDTO> reportPage = reportPageServiceImpl.getReportPage(pageable, totalPages);

        System.out.println("Controller = " + reportPage.getPageable());
        System.out.println("reportPageHasNext = " + reportPage.hasNext());
        System.out.println("reportPageHasPrevious = " + reportPage.hasPrevious());
        System.out.println("reportPageIsLast = " + reportPage.isLast());
        System.out.println("reportPageNextPageable = " + reportPage.nextPageable());
        System.out.println("reportPage 현재 페이지 색인 = " + reportPage.getNumber());
        System.out.println("reportPage 페이지 크기 = " + reportPage.getSize());
        System.out.println("reportPage 총 페이지 수 = " + reportPage.getTotalPages());

        return "reportlist";
    }
}
