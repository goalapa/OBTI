package com.goalapa.cacamuca.reportDomain.query.domain.service;

import com.goalapa.cacamuca.reportDomain.query.application.dto.BlackListQueryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlackListPageService {
    Page<BlackListQueryDTO> getBlackListPage(Pageable pageable);
}
