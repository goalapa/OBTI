package com.goalapa.cacamuca.reportDomain.command.application.controller;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDeleteDTO;
import com.goalapa.cacamuca.reportDomain.command.application.service.ReportServiceImpl;
import com.goalapa.cacamuca.reportDomain.command.infrastructure.service.ReportCheckNullServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/report")
public class ReportController {
    private final ReportCheckNullServiceImpl reportCheckNullService;
    private final ReportServiceImpl reportService;

    public ReportController(ReportCheckNullServiceImpl reportCheckNullService, ReportServiceImpl reportService) {
        this.reportCheckNullService = reportCheckNullService;
        this.reportService = reportService;
    }

    @GetMapping("")
    public String getReport (){
        return "report";
    }

    // 신고하기 기능
    @PostMapping("")
    public void saveReport(HttpServletRequest request) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setReportedMemberNo(Integer.parseInt(request.getParameter("reported_member_no")));
        reportDTO.setReportMemberNo(Integer.parseInt(request.getParameter("report_member_no")));
        reportDTO.setReviewNo(Integer.parseInt(request.getParameter("review_no")));
        reportDTO.setReportType(Integer.parseInt(request.getParameter("report_type")));

        // 신고자, 피신고자, 신고된 리뷰가 null 이 아닌지 확인하고 신고 저장
        if (reportCheckNullService.checkNotNull(reportDTO))
            reportService.saveNewReport(reportDTO);
    }

    // 신고 삭제 기능 (admin page 에서)
    @PostMapping("/delete")
    public ResponseEntity<String> acceptReport(@RequestBody ReportDeleteDTO reportDeleteDTO) {

        reportService.deleteReportById(reportDeleteDTO.getReportNo());

        if (reportDeleteDTO.getIsAccept().equals("true")) {
            // 피신고자의 신고 횟수 추가
            reportService.addReportCount(reportDeleteDTO);

            // 피신고자의 누적 신고 횟수를 확인하고 블랙리스트에 추가하는 로직
            reportService.saveBlackList(reportDeleteDTO.getReportedMemberNo());

            // 리뷰의 누적 신고 횟수를 확인하고, 확인 후 누적 신고 횟수 + 1 을 하거나 리뷰를 삭제하는 로직
            reportService.deleteReviewWithReportedCnt(reportDeleteDTO);
        }

        return new ResponseEntity<>("200", HttpStatus.OK);
    }
}
