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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin-page")
public class ReportQueryController {

    private final ReportPageServiceImpl reportPageServiceImpl;

    public ReportQueryController(ReportPageServiceImpl reportPageServiceImpl) {
        this.reportPageServiceImpl = reportPageServiceImpl;
    }

    // 신고 리스트 조회
    @GetMapping("/report-list")
    @ResponseBody
    public ModelAndView getReportListPage(ModelAndView model, @PageableDefault(size = 5, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ReportQueryDTO> reportPage = reportPageServiceImpl.getReportPage(pageable);

        model.addObject("reportPage", reportPage);
        model.setViewName("reportAdminPage");

        return model;
    }
}
