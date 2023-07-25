package com.goalapa.cacamuca.reviewDomain.query.domain.repository;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewWriterDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<QueryReviewDTO> findAllReviews(String foodName, String country);
    List<QueryReviewPicDTO> findAllPictures(String foodName, String country);
    List<QueryReviewWriterDTO> findReviewWriter(String foodName, String country);
    List<QueryReviewDTO> findAllReviewsByName(String search);
    List<QueryReviewPicDTO> findSearchPictures(String search);
    List<QueryReviewWriterDTO> findReviewWriterBySearch(String search);



    QueryReviewDTO findReviewByNo(int no);
    QueryReviewPicDTO findReviewPicByNo(int no);



}
