package com.goalapa.cacamuca.reportDomain.query.application.service;

import com.goalapa.cacamuca.reportDomain.query.application.dto.ReportQueryDTO;
import com.goalapa.cacamuca.reportDomain.query.domain.repository.ReportMapper;
import com.goalapa.cacamuca.reportDomain.query.domain.service.ReportPageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ReportPageServiceImpl implements ReportPageService {

    private final ReportMapper reportMapper;

    public ReportPageServiceImpl(ReportMapper reportMapper) {
        this.reportMapper = reportMapper;
    }

    // 신고 리스트 페이징
    @Override
    @Transactional(readOnly = true)
    public Page<ReportQueryDTO> getReportPage(Pageable pageable) {
        Map<String, Object> map = new HashMap<>();
        map.put("offset", pageable.getOffset());
        map.put("pageSize", pageable.getPageSize());
        map.put("sort", pageable.getSort());

        List<ReportQueryDTO> reportList = new ArrayList<>(reportMapper.getReportPage(map));

        System.out.println("reportList = " + reportList);

        Sort sort = pageable.getSort();
        if (!sort.isUnsorted()) {
            reportList.sort(Comparator.comparing(dto -> getValueBySort(dto, sort)));
        }

        int totalItems = reportMapper.getTotalItems(pageable);

        return new PageImpl<>(reportList, pageable, totalItems);
    }

    private Comparable getValueBySort(ReportQueryDTO dto, Sort sort) {
        Sort.Order order = sort.stream().findFirst().orElseThrow(IllegalArgumentException::new);
        switch (order.getProperty()) {
            case "reviewNo":
                return dto.getReviewNo();
            case "reportNo":
                return dto.getReportNo();
            default:
                throw new IllegalArgumentException("유효하지않은 정렬값입니다.");
        }
    }
}
