package com.goalapa.cacamuca.reportDomain.query.application.service;

import com.goalapa.cacamuca.reportDomain.query.application.dto.BlackListQueryDTO;
import com.goalapa.cacamuca.reportDomain.query.domain.repository.BlackListMapper;
import com.goalapa.cacamuca.reportDomain.query.domain.service.BlackListPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlackListPageServiceImpl implements BlackListPageService {

    private final BlackListMapper blackListMapper;

    @Autowired
    public BlackListPageServiceImpl(BlackListMapper blackListMapper) {
        this.blackListMapper = blackListMapper;
    }

    // 블랙리스트 페이징
    @Override
    @Transactional(readOnly = true)
    public Page<BlackListQueryDTO> getBlackListPage(Pageable pageable) {
        List<BlackListQueryDTO> blackList = new ArrayList<>(blackListMapper.getBlackListPage(pageable));

        int totalItems = blackListMapper.getTotalItems(pageable);
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), totalItems);

        // 목록이 없으면 빈페이지 생성
        if (start > blackList.size())
            return new PageImpl<>(new ArrayList<>(), pageable, blackList.size());


        return new PageImpl<>(blackList.subList(start, end), pageable, totalItems);
    }
}
