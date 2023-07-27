package com.goalapa.cacamuca.foodDomain.query.domain.service;

import com.goalapa.cacamuca.foodDomain.query.domain.mapper.FoodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Class :
 * Comment :
 * History
 * </pre>
 *
 * @author
 */
@Service
@RequiredArgsConstructor
public class QueryFoodService {

    private final FoodMapper foodMapper;

    public List<Map<String, Object>> getFoodImageUrl() {

        return null;
    }
}
