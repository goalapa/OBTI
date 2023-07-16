package com.goalapa.cacamuca.reportDomain.query.application.service;

import com.goalapa.cacamuca.reportDomain.query.application.dto.ReportQueryDTO;
import com.goalapa.cacamuca.reportDomain.query.domain.repository.ReportMapper;
import com.goalapa.cacamuca.reportDomain.query.domain.service.ReportPageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportPageServiceImpl implements ReportPageService {

    private final ReportMapper reportMapper;

    public ReportPageServiceImpl(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    // 신고 리스트 페이징
    @Override
    @Transactional
    public Page<ReportQueryDTO> getReportPage(Pageable pageable) {
        List<ReportQueryDTO> reportList = new ArrayList<>(reportMapper.getReportPage(pageable));

        int totalItems = reportMapper.getTotalItems(pageable);
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), totalItems);

        // 목록이 없으면 빈페이지 생성
        if (start > reportList.size())
            return new PageImpl<>(new ArrayList<>(), pageable, reportList.size());

        return new PageImpl<>(reportList.subList(start, end), pageable, totalItems);
    }
}
