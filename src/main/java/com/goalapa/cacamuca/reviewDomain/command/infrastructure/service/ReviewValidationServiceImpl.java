package com.goalapa.cacamuca.reviewDomain.command.infrastructure.service;

import com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity.Like;
import com.goalapa.cacamuca.likeDomain.command.domain.repository.LikeRepository;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.service.ReviewValidationService;
import org.springframework.stereotype.Service;

@Service
public class ReviewValidationServiceImpl implements ReviewValidationService {

    private final LikeRepository likeRepository;

    public ReviewValidationServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public boolean checkCondition(Review review, Integer no, Integer loginMemberNo) {
        if (review.getLikeCnt() == null) {
            review.setLikeCnt(0);
        }

        if (likeRepository.findByReviewNoAndMemberNo(no, loginMemberNo).isPresent()) {
            review.setLikeCnt(review.getLikeCnt() - 1);

            Like like = likeRepository.findByMemberNo(loginMemberNo);
            likeRepository.delete(like);

            return false;
        }

        return true;
    }
}
