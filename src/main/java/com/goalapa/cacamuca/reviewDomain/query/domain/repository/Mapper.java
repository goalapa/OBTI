package com.goalapa.cacamuca.reviewDomain.query.domain.repository;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {
    List<QueryReviewPicDTO> findAllPictures();
    List<QueryReviewDTO> findAllReviews();
}
