package com.goalapa.cacamuca.reviewDomain.query.domain.repository;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewFoodDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewWriterDTO;
import com.goalapa.cacamuca.statDomain.query.application.dto.QueryStatDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<QueryReviewDTO> findAllReviews(String foodName, String country);
    List<QueryReviewPicDTO> findAllPictures(String foodName, String country);
    List<QueryReviewWriterDTO> findReviewWriter(String foodName, String country);
    List<QueryReviewDTO> findAllReviewsByName(String search);
    List<QueryReviewPicDTO> findSearchPictures(String search);
    List<QueryReviewWriterDTO> findReviewWriterBySearch(String search);
    List<QueryReviewFoodDTO> findFoodNameByCountryAndFoodType(String country, String foodType);


    QueryReviewDTO findReviewByNo(int no);
    QueryReviewPicDTO findReviewPicByNo(int no);
    QueryReviewWriterDTO findReviewWriterByReviewNo(int reviewNo);
    QueryStatDTO findBestReviewByFoodNo(int foodNo);
    QueryReviewDTO findRecentPrice(String foodName, String country);
}
