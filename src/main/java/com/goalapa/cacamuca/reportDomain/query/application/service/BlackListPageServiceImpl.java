package com.goalapa.cacamuca.reportDomain.query.application.service;

import com.goalapa.cacamuca.reportDomain.query.application.dto.BlackListQueryDTO;
import com.goalapa.cacamuca.reportDomain.query.application.dto.ReportQueryDTO;
import com.goalapa.cacamuca.reportDomain.query.domain.repository.BlackListMapper;
import com.goalapa.cacamuca.reportDomain.query.domain.service.BlackListPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

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

        Sort sort = pageable.getSort();
        if (!sort.isUnsorted()) {
            blackList.sort(Comparator.comparing(dto -> getValueBySort(dto, sort)));
        }

        int totalItems = blackListMapper.getTotalItems(pageable);
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), totalItems);

        // 목록이 없으면 빈페이지 생성
        if (start > blackList.size())
            return new PageImpl<>(new ArrayList<>(), pageable, blackList.size());

        return new PageImpl<>(blackList.subList(start, end), pageable, totalItems);
    }

    private Comparable getValueBySort(BlackListQueryDTO dto, Sort sort) {
        Sort.Order order = sort.stream().findFirst().orElseThrow(IllegalArgumentException::new);

        Comparable value;
        switch (order.getProperty()) {
            case "memberNo":
                value = dto.getMemberNo();
                break;
            case "blacklistNo":
                value = dto.getBlackListNo();
                break;
            case "blacklistRegDate":
                value = dto.getBlackListRegDate();
                break;
            case "blacklistRelDate": {
                if (dto.getBlackListRelDate() == null) {
                    value = LocalDate.now().minusYears(100);
                }
                else {
                    value = dto.getBlackListRelDate();
                }

                break;
            }
            default:
                throw new IllegalArgumentException("유효하지않은 정렬값입니다.");
        }

        return value != null ? value : 0;
    }
}
