package com.goalapa.cacamuca.reportDomain.command.domain.service;

import com.goalapa.cacamuca.reportDomain.command.application.dto.ReportCreateDTO;

public interface ReportCheckNullService {

    // 피신고자, 리뷰가 null이 아닌지 확인
    boolean checkNotNull(ReportCreateDTO reportCreateDTO);

}
