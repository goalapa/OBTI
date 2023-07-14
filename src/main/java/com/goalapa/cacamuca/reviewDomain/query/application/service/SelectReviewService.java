package com.goalapa.cacamuca.reviewDomain.query.application.service;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.domain.repository.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SelectReviewService {

    private final ReviewMapper mapper;

//    @Transactional(readOnly = true)
//    public List<QueryReviewPicDTO> getPictures() {
//        List<QueryReviewPicDTO> reviewPics = mapper.findAllPictures();
//
//        return reviewPics;
//    }

    public List<QueryReviewDTO> findAllReviews() {
        System.out.println("넘버원");
        List<QueryReviewDTO> reviews = mapper.findAllReviews();

        return reviews;
    }

    public QueryReviewDTO findReviewByNo(int no) {
        System.out.println("넘버투");
        QueryReviewDTO review = mapper.findReviewByNo(no);
        return review;
    }

    public QueryReviewDTO findReviewByNo2(int no) {
        System.out.println("넘버쓰리");
        QueryReviewDTO review = mapper.findReviewByNo(no);
        return review;
    }
}
