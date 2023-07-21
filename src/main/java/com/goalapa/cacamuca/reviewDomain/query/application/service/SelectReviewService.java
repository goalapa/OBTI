package com.goalapa.cacamuca.reviewDomain.query.application.service;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import com.goalapa.cacamuca.reviewDomain.query.domain.repository.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SelectReviewService {

    private final ReviewMapper mapper;

    private static String root = "C:\\app-file";
    //    private static String root = "./app-file";
    private static String filePath = root + "/uploadFiles";

    @Transactional(readOnly = true)
    public List<QueryReviewDTO> findAllReviews() {
        List<QueryReviewDTO> reviews = mapper.findAllReviews();

        return reviews;
    }

    @Transactional(readOnly = true)
    public List<QueryReviewPicDTO> findAllPictures() {
        List<QueryReviewPicDTO> reviewPics = mapper.findAllPictures();

        System.out.println("저장된 사진의 경로는 = " + reviewPics);


        return reviewPics;
    }

    @Transactional(readOnly = true)
    public QueryReviewDTO findReviewByNo(int no) {
        QueryReviewDTO review = mapper.findReviewByNo(no);
        return review;
    }


    public List<QueryReviewDTO> searchReviews(String search) {
        List<QueryReviewDTO> reviews = mapper.findAllReviewsBySearch(search);
        return reviews;
    }
}
