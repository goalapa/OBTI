package com.goalapa.cacamuca.reviewDomain.query.application.service;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import com.goalapa.cacamuca.reviewDomain.query.domain.repository.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SelectReviewService {

    private final ReviewMapper mapper;

    private static String root = "C:\\app-file";
    private static String filePath = root + "/uploadFiles";

    @Transactional(readOnly = true)
    public List<QueryReviewDTO> findAllReviews() {
        List<QueryReviewDTO> reviews = mapper.findAllReviews();

        return reviews;
    }

    @Transactional(readOnly = true)
    public List<QueryReviewPicDTO> findAllPictures() {
        List<QueryReviewPicDTO> reviewPics = mapper.findAllPictures();
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
    public List<QueryReviewDTO> searchReviews(String search) {
        List<QueryReviewDTO> reviews = mapper.findAllReviewsBySearch(search);
        System.out.println("reviews = " + reviews);
        return reviews;
    }
}
