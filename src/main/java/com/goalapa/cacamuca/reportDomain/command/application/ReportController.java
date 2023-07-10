package com.goalapa.cacamuca.reportDomain.command.application;

import com.goalapa.cacamuca.reportDomain.command.infrastructure.repository.ReportRepository;
import com.goalapa.cacamuca.reportDomain.command.infrastructure.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReportController {
    private final ReportService reportService;


    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("report/{reportMemberNo}")
    public void saveReport(HttpServletRequest request, Model model, @PathVariable Integer reportMemberNo) {
        Integer reportedMemberNo = (Integer) request.getAttribute("reportedMemberNo");
        String reviewNo = (String) request.getAttribute("reviewNo");
        Integer reviewType = (Integer) request.getAttribute("reviewType");

        // 누적 신고 횟수 조회해서 블랙리스트에 저장하는 로직 추가

        if (reportService.checkNotNull(reportedMemberNo, reportMemberNo, reviewNo))
            reportService.saveReportService(reportedMemberNo, reportMemberNo, reviewNo, reviewType);
    }
}
