package com.goalapa.cacamuca.reportDomain.command.application.controller;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.application.service.ReportServiceImpl;
import com.goalapa.cacamuca.reportDomain.command.infrastructure.service.ReportCheckNullServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/*")
public class ReportController {
    private final ReportCheckNullServiceImpl reportCheckNullService;
    private final ReportServiceImpl reportService;

    public ReportController(ReportCheckNullServiceImpl reportCheckNullService, ReportServiceImpl reportService) {
        this.reportCheckNullService = reportCheckNullService;
        this.reportService = reportService;
    }

    @GetMapping("/report")
    public String getReport (){
        return "report";
    }

    // 신고하기 기능
    @PostMapping("/report")
    public void saveReport(HttpServletRequest request) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setReportedMemberNo(Integer.parseInt(request.getParameter("reported_member_no")));
        reportDTO.setReportMemberNo(Integer.parseInt(request.getParameter("report_member_no")));
        reportDTO.setReviewNo(Integer.parseInt(request.getParameter("review_no")));
        reportDTO.setReportType(Integer.parseInt(request.getParameter("report_type")));
        System.out.println("reportDTO = " + reportDTO);
        System.out.println("Controller");

        // 누적 신고 횟수 조회해서 블랙리스트에 저장하는 로직 추가

        // 신고자, 피신고자, 신고된 리뷰가 null이 아닌지 확인하고 신고 저장
        if (reportCheckNullService.checkNotNull(reportDTO))
            reportService.saveNewReport(reportDTO);
    }
}
