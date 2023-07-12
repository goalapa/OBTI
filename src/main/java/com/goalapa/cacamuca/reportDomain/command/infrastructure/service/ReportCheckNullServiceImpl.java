package com.goalapa.cacamuca.reportDomain.command.infrastructure.service;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportDTO;
import com.goalapa.cacamuca.reportDomain.command.domain.service.ReportCheckNullService;
import org.springframework.stereotype.Service;


@Service
public class ReportCheckNullServiceImpl implements ReportCheckNullService {

    // 신고자, 피신고자, 리뷰가 null이 아닌지 확인하는 로직 추가
    @Override
    public boolean checkNotNull(ReportDTO reportDTO) {
        return true;
    }
}
