package com.goalapa.cacamuca.reviewDomain.query.domain.repository;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
//    List<QueryReviewPicDTO> findAllPictures();
    List<QueryReviewDTO> findAllReviews();

    QueryReviewDTO findReviewByNo(int no);

    List<QueryReviewPicDTO> findAllPictures(int no);
}
