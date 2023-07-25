package com.goalapa.cacamuca.reviewDomain.query.application.service;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewWriterDTO;
import com.goalapa.cacamuca.reviewDomain.query.domain.repository.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SelectReviewService {

    private final ReviewMapper mapper;

    @Transactional(readOnly = true)
    public List<QueryReviewDTO> findAllReviews(String foodName, String country) {
        List<QueryReviewDTO> reviews = mapper.findAllReviews(foodName, country);
        return reviews;
    }

    @Transactional(readOnly = true)
    public Page<QueryReviewDTO> findAllReviews(String foodName, String country, Pageable pageable) {
        List<QueryReviewDTO> reviews = mapper.findAllReviews(foodName, country);

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), reviews.size());

        if (start > reviews.size())
            return new PageImpl<>(new ArrayList<>(), pageable, reviews.size());

        return new PageImpl<>(reviews.subList(start, end), pageable, reviews.size());
    }

    @Transactional(readOnly = true)
    public List<QueryReviewPicDTO> findAllPictures(String foodName, String country) {
        List<QueryReviewPicDTO> reviewPics = mapper.findAllPictures(foodName, country);
        return reviewPics;
    }

    @Transactional(readOnly = true)
    public QueryReviewDTO findReviewByNo(int no) {
        QueryReviewDTO review = mapper.findReviewByNo(no);
        return review;
    }

    @Transactional(readOnly = true)
    public QueryReviewPicDTO findReviewPicByNo(int no) {
        QueryReviewPicDTO reviewPic = mapper.findReviewPicByNo(no);
        return reviewPic;
    }

    @Transactional(readOnly = true)
    public Page<QueryReviewDTO> searchReviews(String search, Pageable pageable) {
        List<QueryReviewDTO> searchReviews = mapper.findAllReviewsByName(search);

        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), searchReviews.size());

        if (start > searchReviews.size())
            return new PageImpl<>(new ArrayList<>(), pageable, searchReviews.size());

        return new PageImpl<>(searchReviews.subList(start, end), pageable, searchReviews.size());
    }

    @Transactional(readOnly = true)
    public List<QueryReviewPicDTO> findAllPictures(String search) {
        List<QueryReviewPicDTO> reviewPics = mapper.findSearchPictures(search);
        return reviewPics;
    }

    @Transactional(readOnly = true)
    public List<QueryReviewWriterDTO> findReviewWriter(String foodName, String country) {
        List<QueryReviewWriterDTO> reviewWriter = mapper.findReviewWriter(foodName, country);
        return reviewWriter;
    }
    @Transactional(readOnly = true)
    public List<QueryReviewWriterDTO> findReviewWriter(String search) {
        List<QueryReviewWriterDTO> reviewWriter = mapper.findReviewWriterBySearch(search);
        return reviewWriter;
    }
}
