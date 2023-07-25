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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> map = new HashMap<>();
        map.put("offset", pageable.getOffset());
        map.put("pageSize", pageable.getPageSize());
        map.put("sort", pageable.getSort());

        List<BlackListQueryDTO> blackList = new ArrayList<>(blackListMapper.getBlackListPage(map));

        int totalItems = blackListMapper.getTotalItems(pageable);

        return new PageImpl<>(blackList, pageable, totalItems);
    }
}
