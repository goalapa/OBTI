package com.goalapa.cacamuca.reviewDomain.query.application.service;

import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewDTO;
import com.goalapa.cacamuca.reviewDomain.query.application.dto.QueryReviewPicDTO;
import com.goalapa.cacamuca.reviewDomain.query.domain.repository.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SelectReviewService {
    @Autowired
    private Mapper mapper;

    @Transactional(readOnly = true)
    public QueryReviewPicDTO getPictures() {
//        SqlSession sqlSession = getSession();
//
//        Mapper menuMapper = sqlSession.getMapper(Mapper.class);
//
//        List<QueryReviewPicDTO> pictures = menuMapper.findAllPictures();
//
//        sqlSession.close();
//
//        return pictures;
        return null;
    }

    @Transactional(readOnly = true)
    public QueryReviewDTO getReviews() {
//        List list =
//        List<QueryReviewDTO> reviews = menuMapper.findAllReviews();
    }
}
