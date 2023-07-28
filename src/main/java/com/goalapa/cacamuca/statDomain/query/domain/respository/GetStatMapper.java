package com.goalapa.cacamuca.statDomain.query.domain.respository;

import com.goalapa.cacamuca.statDomain.query.application.dto.QueryStatDTO;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;
@Mapper
public interface GetStatMapper {
    List<QueryStatDTO> getStatTopTen(LocalDate date, String country);
    List<Integer> getLikeCntByMonth(int foodNo);
    List<Integer> getReviewCntByMonth(int foodNo);
    List<Float> getFoodRate(int foodNo);
    Float getGenderRatio(int foodNo);
    List<Integer> getAgeGroup(int foodNo);
}
