package com.goalapa.cacamuca.reviewDomain.command.infrastructure.service;

import com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity.Like;
import com.goalapa.cacamuca.likeDomain.command.domain.repository.LikeRepository;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReportedMemberVO;
import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.ReviewVO;
import com.goalapa.cacamuca.reportDomain.command.domain.repository.ReportRepository;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.service.ReviewValidationService;
import org.springframework.stereotype.Service;

@Service
public class ReviewValidationServiceImpl implements ReviewValidationService {

    private final LikeRepository likeRepository;
    private final ReportRepository reportRepository;

    public ReviewValidationServiceImpl(LikeRepository likeRepository, ReportRepository reportRepository) {
        this.likeRepository = likeRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    public boolean checkHeartCondition(Review review, Integer no, Integer loginMemberNo) {
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


    @Override
    public boolean checkReportCondition(Review review, ReviewVO reviewVO, ReportMemberVO reportMemberVO,
                                        ReportedMemberVO reportedMemberVO) {
        if (review.getReportCnt() == null){
            review.setReportCnt(0);
        }

        System.out.println("reportMemberVO = " + reportMemberVO);
        System.out.println("reportedMemberVO = " + reportedMemberVO);

        if (reportMemberVO.getReportMemberNo() == reportedMemberVO.getReportedMemberNo()){
            System.out.println("자신의 글은 신고할 수 없습니다.");
            return false;
        }

        if(reportRepository.findByReviewVOAndReportMemberVO(reviewVO, reportMemberVO).isPresent()){
            System.out.println("이미 신고한적이 있습니다.");
            return false;
        }
        return true;
    }
}
